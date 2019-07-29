package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.ProductApplication;
import com.morning.star.retail.dao.ProductDAO;
import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.entity.ProductImgEntity;
import com.morning.star.retail.entity.UpcCodeEntity;
import com.morning.star.retail.entity.repository.GoodsRepository;
import com.morning.star.retail.entity.repository.ProductImgRepository;
import com.morning.star.retail.entity.repository.ProductRepository;
import com.morning.star.retail.entity.repository.UpcCodeRepository;
import com.morning.star.retail.enums.ProductImgType;
import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.assembler.ProductDTOAssembler;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.listener.mq.ImportProductQueue;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class ProductFacadeImpl implements ProductFacade {

	@Autowired
	private ProductApplication productApplication;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UpcCodeRepository upcCodeRepository;
	@Autowired
	private ProductImgRepository productImgRepository;

	@Autowired
	private ImportProductQueue importProductQueue;

	@Autowired
	private GoodsRepository goodsRepository;

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<String> getSapCodeByUpc(String upcCode) {
		List<UpcCodeEntity> upcCodeEntityList = upcCodeRepository.getByUpcCode(upcCode);
		if (upcCodeEntityList == null || upcCodeEntityList.size() < 1) {
			return null;
		}
		return upcCodeEntityList.stream().map(UpcCodeEntity::getSapProductCode).distinct().collect(Collectors.toList());
	}

	@Override
	public void addProduct(List<ProductSubmitDTO> dtos) {
		productApplication.add(dtos);
	}

	@Override
	@com.morning.star.retail.validate.Validate
	public void submitImportProduct(List<ProductImportDTO> dtos) {
		importProductQueue.send(dtos);
	}

	@Override
	public void importProduct(List<ProductImportDTO> dtos) {
		productApplication.batchImport(dtos);
	}

	@Override
	public void pullProduct(ProductPullDTO dto) {
		productApplication.pullProduct(dto);
	}

	@Override
	public void updateProduct(List<ProductUpdateDTO> dtos) {
		productApplication.update(dtos);
	}

	@Override
	public PageBean<ProductDTO> queryProduct(ProductQueryDTO productQueryDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(productQueryDTO.getPageNo(), productQueryDTO.getPageSize());
		Page<ProductDTO> productDTOS = productDAO.query(productQueryDTO, rowBounds);
		return new PageBeanAssembler().toBean(productDTOS);
	}

	@Override
	public List<ProductDTO> queryList(ProductQueryDTO dto) {
		if (StringUtils.isBlank(dto.getUpcCode()) && StringUtils.isBlank(dto.getProductName())) {
			return new ArrayList<>();
		}
		return productDAO.queryList(dto);
	}

	@Override
	public PageBean<ProductPullInfoDTO> queryForPull(ProductQueryDTO productQueryDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(productQueryDTO.getPageNo(), productQueryDTO.getPageSize());
		Page<ProductPullInfoDTO> productDTOS = productDAO.queryForPull(productQueryDTO, rowBounds);
		productDTOS.getResult().forEach(e -> {
			Boolean isExits = goodsRepository.existsByProductInfoProductCodeAndStoreCode(e.getProductCode(), productQueryDTO.getStoreCode());
			if (isExits) {
				e.setIsPull(1);
			} else {
				e.setIsPull(0);
			}
		});
		return new PageBeanAssembler().toBean(productDTOS);
	}

	@Override
	public ProductDTO getDetail(ProductGetDTO dto) {
		Validate.isTrue(StringUtils.isNotBlank(dto.getProductCode()),
			"查询参数为空");
		ProductEntity productEntity = productRepository.findOne(dto.getProductCode());
		ProductDTO productDTO = null;
		if (productEntity != null) {
			productDTO = new ProductDTOAssembler().toDTO(productEntity);
			fillImg(productDTO);
		}
		return productDTO;
	}

	@Override
	public ProductDTO getBySapCode(String groupCode, String sapCode) {
		ProductEntity productEntity;

		if (StringUtils.isNotBlank(groupCode) && StringUtils.isNotBlank(sapCode)) {
			productEntity = productRepository.getByGroupCodeAndSapProductCode(groupCode, sapCode);
		} else {
			throw new IllegalArgumentException("查询参数为空");
		}
		if (productEntity != null) {
			ProductDTO productDTO = new ProductDTOAssembler().toDTO(productEntity);
			fillImg(productDTO);
			return productDTO;
		} else {
			return null;
		}
	}

	@Override
	public List<ProductDTO> getByUpc(ProductGetUpcDTO dto) {
		List<UpcCodeEntity> upcCodeEntityList = upcCodeRepository.getByUpcCode(dto.getProductUpc());
		if (upcCodeEntityList == null || upcCodeEntityList.size() < 1) {
			return null;
		}
		return upcCodeEntityList.stream().map(e -> {
			ProductEntity entity = productRepository.getByGroupCodeAndProductCode(dto.getGroupCode(), e.getProductCode());
			ProductDTO productDTO = new ProductDTOAssembler().toDTO(entity);
			if (productDTO != null) {
				fillImg(productDTO);
			}
			return productDTO;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	/**
	 * 获取商品图片信息，填写入商品信息中
	 */
	private void fillImg(ProductDTO productDTO) {
		List<ProductImgEntity> imgList = productImgRepository.getByProductCode(productDTO.getProductCode());
		Map<ProductImgType, List<ProductImgEntity>> groupImgList = imgList.stream().collect(groupingBy(ProductImgEntity::getImgType));
		if (groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			productDTO.setImgPaths(imgPathStr);
		}
		if (groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			productDTO.setIntroImgPaths(imgPathStr);
		}
	}

	@Override
	public void onMarket(List<String> productCodes) {
		productApplication.onMarket(productCodes);
	}

	@Override
	public void offMarket(List<String> productCodes) {
		productApplication.offMarket(productCodes);
	}

	@Override
	public void onSale(List<String> productCodes) {
		productApplication.onSale(productCodes);
	}

	@Override
	public void offSale(List<String> productCodes) {
		productApplication.offSale(productCodes);
	}

	@Override
	public ProductDTO getByProductCode(String productCode) {
		ProductEntity productEntity = productRepository.findOne(productCode);
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copy(productEntity, productDTO);
		return productDTO;
	}

	@Override
	public ProductDTO getByCode(String productCode) {
		return productApplication.getByCode(productCode);
	}
}
