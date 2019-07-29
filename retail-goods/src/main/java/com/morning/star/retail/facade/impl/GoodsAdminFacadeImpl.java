package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.GoodsApplication;
import com.morning.star.retail.dao.GoodsDAO;
import com.morning.star.retail.entity.GoodsEntity;
import com.morning.star.retail.entity.ProductImgEntity;
import com.morning.star.retail.entity.UpcCodeEntity;
import com.morning.star.retail.entity.repository.GoodsRepository;
import com.morning.star.retail.entity.repository.ProductImgRepository;
import com.morning.star.retail.entity.repository.UpcCodeRepository;
import com.morning.star.retail.enums.ProductImgType;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.assembler.GoodsDTOAssembler;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class GoodsAdminFacadeImpl implements GoodsAdminFacade {

	@Autowired
	private GoodsRepository storeGoodsRepository;
	@Autowired
	private UpcCodeRepository upcCodeRepository;
	@Autowired
	private ProductImgRepository productImgRepository;
	@Autowired
	private GoodsApplication goodsApplication;
	@Autowired
	private GoodsDAO storeGoodsDAO;


	@Transactional
	@Override
	public String createStoreGoods(GoodsPullDTO goodsPullDTO) {
		return goodsApplication.createStoreGoods(goodsPullDTO);
	}

	@Override
	public GoodsDTO getGoods(String goodsCode) {

		GoodsEntity entity = storeGoodsRepository.findOne(goodsCode);
		if (entity == null) {
			return null;
		}
		GoodsDTO goodsDTO = new GoodsDTOAssembler().toDTO(entity);
		fillImgForStore(goodsDTO);
		return goodsDTO;
	}

	@Override
	public GoodsDTO getBySapCode(String storeCode, String sapCode) {
		GoodsEntity entity = storeGoodsRepository.findOneByStoreCodeAndProductInfoSapProductCode(storeCode, sapCode);
		if (entity == null) {
			return null;
		}
		GoodsDTO goodsDTO = new GoodsDTOAssembler().toDTO(entity);
		fillImg(goodsDTO);
		return goodsDTO;
	}

	@Override
	public GoodsDTO getMotherGoods(String goodsCode) {
		GoodsEntity entity = storeGoodsRepository.findOne(goodsCode);
		if (entity == null || StringUtils.isBlank(entity.getProductInfo().getSapMotherCode())) {
			return null;
		}
		GoodsEntity motherEntity = storeGoodsRepository.findByStoreCodeAndProductInfoSapMotherCode(
			entity.getStoreCode(),
			entity.getProductInfo().getSapMotherCode());

		if (motherEntity == null) {
			return null;
		}
		GoodsDTO goodsDTO = new GoodsDTOAssembler().toDTO(motherEntity);
		fillImg(goodsDTO);
		return goodsDTO;

	}

	@Override
	public GoodsDTO getGoodsByCode(String storeCode, String productCode) {
		GoodsEntity entity = storeGoodsRepository.getByStoreCodeAndProductInfoProductCode(storeCode, productCode);
		if (entity == null) {
			return null;
		}
		GoodsDTO goodsDTO = new GoodsDTOAssembler().toDTO(entity);
		fillImg(goodsDTO);
		return goodsDTO;
	}

	@Override
	public List<GoodsDTO> getGoodsByUpc(String storeCode, String upcCode) {
		GoodsDTOAssembler goodsDTOAssembler = new GoodsDTOAssembler();
		List<UpcCodeEntity> upcCodeEntityList = upcCodeRepository.getByUpcCode(upcCode);
		if (upcCodeEntityList == null || upcCodeEntityList.size() == 0) {
			return null;
		}
		return upcCodeEntityList.stream().map(e -> {
			GoodsEntity entity = storeGoodsRepository.getByStoreCodeAndProductInfoProductCode(storeCode, e.getProductCode());
			GoodsDTO goodsDTO = goodsDTOAssembler.toDTO(entity);
			if (goodsDTO != null) {
				fillImg(goodsDTO);
			}
			return goodsDTO;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	/**
	 * 获取商品图片信息，填写入商品信息中
	 */
	private void fillImg(GoodsDTO goodsDTO) {
		List<ProductImgEntity> imgList = productImgRepository.getByProductCode(goodsDTO.getProductCode());
		Map<ProductImgType, List<ProductImgEntity>> groupImgList = imgList.stream().collect(groupingBy(ProductImgEntity::getImgType));
		if (groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			goodsDTO.setImgPaths(imgPathStr);
		}
		if (groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			goodsDTO.setIntroImgPaths(imgPathStr);
		}
	}

	/**
	 * 获取商品图片信息，填写入商品信息中
	 */
	private void fillImgForStore(GoodsDTO goodsDTO) {
		List<ProductImgEntity> imgList = productImgRepository.getByProductCode(goodsDTO.getGoodsCode());
		Map<ProductImgType, List<ProductImgEntity>> groupImgList = imgList.stream().collect(groupingBy(ProductImgEntity::getImgType));
		if (groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			goodsDTO.setImgPaths(imgPathStr);
		}
		if (groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			goodsDTO.setIntroImgPaths(imgPathStr);
		}
	}

	@Transactional
	@Override
	public void makePrice(String goodsCode, BigDecimal price) {
		goodsApplication.makePrice(goodsCode, price);
	}

	@Transactional
	@Override
	public void onSale(String code) {
		goodsApplication.onSale(code);
	}

	@Transactional
	@Override
	public void offSale(String code) {
		goodsApplication.offSale(code);
	}

	@Override
	public PageBean<GoodsDTO> queryGoods(GoodsQueryDTO dto) {
		RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		Page<GoodsDTO> result = storeGoodsDAO.query(dto, rowBounds);
		return new PageBeanAssembler().toBean(result);
	}

	@Override
	public List<GoodsDTO> queryList(GoodsQueryDTO dto) {
		if (StringUtils.isBlank(dto.getUpcCode()) && StringUtils.isBlank(dto.getProductName())) {
			return new ArrayList<>();
		}
		return storeGoodsDAO.queryList(dto);
	}

	@Override
	public PageBean<GoodsDTO> queryGoodsForCity(GoodsQueryDTO dto) {
		RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		Page<GoodsDTO> result = storeGoodsDAO.queryForCity(dto, rowBounds);
		return new PageBeanAssembler().toBean(result);
	}

	@Override
	public void batchPull(List<GoodsPullDTO> goodsPullDTOS) {
		goodsApplication.batchPull(goodsPullDTOS);
	}

	@Override
	public void addGoods(List<GoodsSubmitDTO> dtos) {
		goodsApplication.addGoods(dtos);
	}

	@Override
	public void update(GoodsUpdateDTO dto) {
		goodsApplication.update(dto);
	}

	@Override
	public void syncGoods(String groupCode, String storeCode) {
		goodsApplication.syncGoods(groupCode, storeCode);
	}

	@Override
	public void syncProductInfo(ProductSyncGoodsDTO dto) {
		goodsApplication.syncProductInfo(dto);
	}
}
