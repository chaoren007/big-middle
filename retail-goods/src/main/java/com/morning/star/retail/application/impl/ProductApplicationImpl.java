package com.morning.star.retail.application.impl;

import com.morning.star.retail.application.ProductApplication;
import com.morning.star.retail.application.ProductImgApplication;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.entity.*;
import com.morning.star.retail.entity.repository.*;
import com.morning.star.retail.enums.*;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.helper.SupplierService;
import com.morning.star.retail.helper.vo.StoreInfo;
import com.morning.star.retail.listener.mq.SyncProductQueue;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.redis.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

@Service
@Transactional
public class ProductApplicationImpl implements ProductApplication {
	private Logger logger = LoggerFactory.getLogger(ProductApplicationImpl.class);

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private UnitsRepository unitsRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductSpecRepository productSpecRepository;
	@Autowired
	private UpcCodeRepository upcCodeRepository;
	@Autowired
	private ProductImgApplication productImgApplication;

	@Autowired
	private SyncProductQueue syncProductQueue;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private StoreService storeService;


	@Override
	@com.morning.star.retail.validate.Validate
	public List<String> add(List<ProductSubmitDTO> dtos) {
		Validate.notEmpty(dtos, "无添加数据");
		Validate.notEmpty(dtos.get(0).getGroupCode(), "集团编码不能为空");
		String spuCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.SPU);

		// 校验添加货品重复UPC编码（只允许服饰UPC重复）
		List<String> allUpcCode = new ArrayList<>();
		dtos.stream().map(item -> Arrays.asList(item.getUpcCode().split(","))).forEach(item -> allUpcCode.addAll(item));
		if (dtos.get(0).getCommodityType().equals(CommodityTypeEnum.CLOTHES.getCode())) {
			Set<String> upcCheckSet = new HashSet<>();
			upcCheckSet.addAll(allUpcCode);
			Validate.isTrue(allUpcCode.size() == upcCheckSet.size(), "提交数据存在重复UPC");
		}

		//商品名称判断是否重复
		Boolean isExits = productRepository.existsByProductName(dtos.get(0).getProductName());
		Validate.isTrue(!isExits, "商品名称已经存在:" + dtos.get(0).getProductName());

		//有母码判断母码是否存在
		if (StringUtils.isNotBlank(dtos.get(0).getMotherCode())) {
			Boolean isCode = productRepository.existsByProductCode(dtos.get(0).getMotherCode());
			Validate.isTrue(isCode, "所填母码不存在:" + dtos.get(0).getMotherCode());

			ProductEntity one = productRepository.findOne(dtos.get(0).getMotherCode());
			Validate.isTrue(one.getCommodityType().getCode().equals(dtos.get(0).getCommodityType()), "所填商品类型与母码商品类型不一致");
		}

		List<String> productCodeList = new ArrayList<>(dtos.size());

		dtos.forEach(e -> {
			// 基础数据校验
			Validate.isTrue(CommodityTypeEnum.from(e.getCommodityType()) != null, "商品类型不存在:" + e.getCommodityType());
			Validate.isTrue(StorageTypeEnum.from(e.getStorageType()) != null, "商品存储类型不存在:" + e.getStorageType());

			ProductEntity productEntity = new ProductEntity();
			BeanUtils.copy(e, productEntity);

			// 校验单位信息
			UnitsEntity unitsEntity = unitsRepository.findOne(e.getUnitsId());
			Validate.isTrue(unitsEntity != null, "单位信息不存在:" + e.getUnitsId());
			productEntity.setUnitsName(unitsEntity.getUnitsName());

			// 校验供应商信息
			SupplierDTO supplierDTO = supplierService.get(e.getSupplierCode(), e.getGroupCode());
			Validate.notNull(supplierDTO, "供应商信息不存在:" + e.getSupplierCode());
			productEntity.setSupplierName(supplierDTO.getSupplierName());

			// 校验分类信息
			checkAndFillCategory(e.getCategoryId1(), e.getCategoryId2(), e.getCategoryId3(), e.getCategorySpecInfo(), productEntity);

			// 校验品牌信息
			BrandEntity brandEntity = brandRepository.findOne(e.getBrandId());
			Validate.isTrue(brandEntity != null, "品牌信息不存在:" + e.getBrandId());
			Validate.isTrue(new HashSet<>(Arrays.asList(brandEntity.getCategoryId().split(","))).contains(String.valueOf(e.getCategoryId1())),
				"品牌[" + brandEntity.getBrandName() + "]不包含此分类:" + e.getCategoryId1());

			//单品编码生成
			String productCode = getProductCode(String.valueOf(e.getCategoryId3()));
			Validate.isTrue(!productRepository.existsByProductCode(productCode),
				"新增失败,新增商品的单品编码已经存在:" + productCode);
			productEntity.setProductCode(productCode);

			// UPC校验
			List<String> upcCodes = Arrays.asList(e.getUpcCode().split(","));
			// 校验可重复UPC
			List<UpcCodeEntity> exitsUpcList = upcCodeRepository.getByUpcCodeIn(upcCodes);
			if (exitsUpcList != null && exitsUpcList.size() > 0) {
				exitsUpcList.forEach(upcItem -> {
					if (!upcItem.getProductCode().equals(productCode)) {
						throw new IllegalArgumentException("UPC编码已存在" + upcItem.getUpcCode());
					}
				});
			}

			List<UpcCodeEntity> upcCodeEntityList = upcCodes.stream()
				.map(u -> new UpcCodeEntity(null, productCode, u))
				.collect(Collectors.toList());

			productEntity.setUpcCodeEntityList(upcCodeEntityList);

			// 多规格货品 保存相关规格信息
			if (e.getProductSpecInfo() != null && e.getProductSpecInfo().size() > 0) {
				String spuInfo = ProductSpecDTO.formStr(e.getProductSpecInfo());

				productEntity.setSpuCode(spuCode);
				productEntity.setSpuInfo(spuInfo);

				// 添加规格数据
				e.getProductSpecInfo().forEach(spec -> {
					ProductSpecEntity productSpecEntity = new ProductSpecEntity();
					BeanUtils.copy(spec, productSpecEntity);
					productSpecEntity.setProductCode(productCode);
					productSpecEntity.setSpuCode(spuCode);
					productSpecEntity.setGroupCode(e.getGroupCode());
					productSpecEntity.setIsMain(1);
					productSpecRepository.save(productSpecEntity);
				});
			}

			// 商品图片信息保存
			productImgApplication.add(e.getGroupCode(), null, null, productCode, e.getIconPath(), ProductImgType.ICON);
			productImgApplication.add(e.getGroupCode(), null, null, productCode, e.getImgPaths(), ProductImgType.ATLAS);
			productImgApplication.add(e.getGroupCode(), null, null, productCode, e.getIntroImgPaths(), ProductImgType.INTRODUCE);

			// 设置添加商品默认属性值
			productEntity.setStatus(ProductMarketStatus.OFF_MARKET);
			productEntity.setSaleStatus(GoodsSaleStatus.OFF_SALE);
			productEntity.setProductType("SP");

			//新增城市信息
			if (StringUtils.isNotBlank(e.getStoreCode())) {
				StoreInfo storeInfo = storeService.getByCode(e.getStoreCode());
				productEntity.setCityId(storeInfo.getCityId());
				productEntity.setCityName(storeInfo.getCityName());
			} else {
				productEntity.setCityId(RetailDefaultConst.DEFAULT_CITY_ID);
				productEntity.setCityName(RetailDefaultConst.DEFAULT_CITY_NAME);
			}

			productRepository.save(productEntity);

			productCodeList.add(productEntity.getProductCode());
		});
		return productCodeList;
	}

	/**
	 * 根据分类获取货品编码
	 *
	 * @param categoryCode 分类编码
	 */
	private String getProductCode(String categoryCode) {
		Long suf = redisUtil.incro(categoryCode);
		StringBuilder sufStr = new StringBuilder(String.valueOf(suf));
		int zeroSize = 4 - sufStr.length();
		for (int i = 0; i < zeroSize; i++) {
			sufStr.insert(0, "0");
		}
		return categoryCode + sufStr.toString();
	}

	/**
	 * 校验分类信息，将分类信息填写进货品信息中
	 * @param c1    一级分类
	 * @param c2    二级分类
	 * @param c3    三级分类
	 * @param specList  分类规格信息
	 * @param entity    货品实体
	 */
	void checkAndFillCategory(Long c1, Long c2, Long c3, List<ProductSpecDTO> specList, ProductEntity entity) {
		CategoryEntity category;
		if (c1 != null && c1 > 0) {
			category = categoryRepository.getByCategoryId(c1);
			Validate.notNull(category, "一级分类不存在：" + c1);
			entity.setCategoryId1(category.getCategoryId());
			entity.setCategoryName1(category.getCategoryName());

			if (c2 != null && c2 > 0) {
				category = categoryRepository.getByCategoryId(c2);
				Validate.notNull(category, "二级分类不存在：" + c2);
				Validate.isTrue(category.getParentId().equals(c1), "分类错误");
				entity.setCategoryId2(category.getCategoryId());
				entity.setCategoryName2(category.getCategoryName());
			}

			if (c3 != null && c3 > 0) {
				category = categoryRepository.getByCategoryId(c3);
				Validate.notNull(category, "三级分类不存在：" + c3);
				Validate.isTrue(category.getParentId().equals(c2), "分类错误");
				entity.setCategoryId3(category.getCategoryId());
				entity.setCategoryName3(category.getCategoryName());

				String spuInfo = "";
				if (specList != null && specList.size() > 0) {
					spuInfo = ProductSpecDTO.formStr(specList);
				}
				entity.setCategorySpuInfo(spuInfo);
			}
		} else {
			throw new IllegalArgumentException("一级分类没有");
		}
	}

	@Override
	@com.morning.star.retail.validate.Validate
	public void batchImport(List<ProductImportDTO> dtos) {
		dtos.forEach(this::checkImportData);
		List<List<ProductSubmitDTO>> groupData = groupImportData(dtos);
		groupData.forEach(this::add);
	}

	void checkImportData(ProductImportDTO dto) {
		Validate.notEmpty(dto.getProductName(), "货品名称不能为空");
		if (dto.getTaxRate() == null || dto.getTaxRate() < 0 || dto.getTaxRate() > 99) {
			dto.setTaxRate(0);
		}
		Validate.notEmpty(dto.getUpcCode(), "UPC编码不能为空");
		Validate.isTrue(dto.getGuidePrice().compareTo(BigDecimal.ZERO) > 0, "指导价小于等于0");
		Validate.isTrue(dto.getSalePrice().compareTo(BigDecimal.ZERO) > 0, "销售价小于等于0");
		Validate.isTrue(dto.getPurchasePrice().compareTo(BigDecimal.ZERO) > 0, "采购价小于等于0");

		dto.setProductCode(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PC));
		dto.setProductType("SP");
	}

	List<List<ProductSubmitDTO>> groupImportData(List<ProductImportDTO> dtos) {
		// 根据是否是多规格商品进行分组
		Map<Boolean, List<ProductImportDTO>> partitioned = dtos.stream()
			.collect(partitioningBy(e -> e.getSpuCode() != null && e.getSpuCode().length() > 0));

		// 非多规格商品直接单品加入
		List<List<ProductSubmitDTO>> groupData = partitioned.getOrDefault(false, new ArrayList<>())
			.stream()
			.map(e -> {
				ProductSubmitDTO dto = new ProductSubmitDTO();
				BeanUtils.copy(e, dto);
				return Collections.singletonList(dto);
			})
			.collect(Collectors.toList());

		// 多规格安装规格集处理
		groupData.addAll(partitioned.getOrDefault(true, new ArrayList<>())
			.stream()
			.map(e -> {
				ProductSubmitDTO dto = new ProductSubmitDTO();
				BeanUtils.copy(e, dto);

				dto.setProductSpecInfo(ProductSpecDTO.builderList(e.getSpuInfo()));
				return dto;
			})
			.collect(groupingBy(ProductSubmitDTO::getSpuCode))
			.values());
		return groupData;
	}

	@Override
	@com.morning.star.retail.validate.Validate
	public void pullProduct(ProductPullDTO dto) {
		// TODO
	}

	@Override
	@com.morning.star.retail.validate.Validate
	public void update(List<ProductUpdateDTO> dtos) {
		Validate.notEmpty(dtos, "无添加数据");
		Validate.notEmpty(dtos.get(0).getGroupCode(), "集团编码不能为空");
		dtos.forEach(e -> {
			ProductEntity productEntity = productRepository.findOne(e.getProductCode());
			Validate.notNull(productEntity, "货品信息不存在");
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", productEntity.getGroupCode())
				.msg("不允许更新该货品：" + e.getProductCode())
				.pass();

			SupplierDTO supplierDTO = supplierService.get(e.getSupplierCode(), e.getGroupCode());
			Validate.notNull(supplierDTO, "供应商信息不存在:" + e.getSupplierCode());
			productEntity.setSupplierCode(supplierDTO.getSupplierCode());
			productEntity.setSupplierName(supplierDTO.getSupplierName());

			productEntity.setIconPath(e.getIconPath());
			productEntity.setCostPrice(e.getCostPrice());
			productEntity.setSalePrice(e.getSalePrice());
			productEntity.setOriginPlace(e.getOriginPlace());

			productImgApplication.deleteByProductCode(e.getProductCode(), e.getGroupCode());
			productImgApplication.add(productEntity.getGroupCode(), null, productEntity.getSapProductCode(), productEntity.getProductCode(),
				e.getIconPath(),
				ProductImgType.ICON);
			productImgApplication.add(productEntity.getGroupCode(), null, productEntity.getSapProductCode(), productEntity.getProductCode(),
				e.getImgPaths(),
				ProductImgType.ATLAS);
			productImgApplication.add(productEntity.getGroupCode(), null, productEntity.getSapProductCode(), productEntity.getProductCode(),
				e.getIntroImgPaths(),
				ProductImgType.INTRODUCE);
			productRepository.save(productEntity);
		});
//		Context.publish(new ProductSyncEvent(dtos.stream().map(dto -> new ProductSyncGoodsDTO(dto.getProductCode(), dto.getGroupCode())).collect(Collectors.toList())));
//		syncProductQueue.send(dtos.stream()
//			.map(dto -> new ProductSyncGoodsDTO(dto.getProductCode(), dto.getGroupCode()))
//			.collect(Collectors.toList()));
	}

	@Override
	public void onMarket(List<String> codes) {
		updateStatus(codes, ProductMarketStatus.ON_MARKET);
	}

	@Override
	public void offMarket(List<String> codes) {
		updateStatus(codes, ProductMarketStatus.OFF_MARKET);
	}


	private void updateStatus(List<String> codes, ProductMarketStatus status) {
		codes.forEach(productCode -> {
			ProductEntity productEntity = productRepository.findOne(productCode);
			Validate.notNull(productEntity, "商品信息不存在");
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", productEntity.getGroupCode())
				.msg("该货品不允许操作：" + productCode)
				.pass();

			productEntity.setStatus(status);
			productRepository.save(productEntity);
		});
		syncProductQueue.send(codes.stream()
			.map(code -> new ProductSyncGoodsDTO(code, UserUtils.currentUser().getTag("groupCode")))
			.collect(Collectors.toList()));
	}

	@Override
	public void onSale(List<String> codes) {
		updateSaleStatus(codes, GoodsSaleStatus.ON_SALE);
	}

	@Override
	public void offSale(List<String> codes) {
		updateSaleStatus(codes, GoodsSaleStatus.OFF_SALE);
	}

	@Override
	public ProductDTO getByCode(String productCode) {
		ProductEntity entity = productRepository.findOne(productCode);
		Validate.notNull(entity, "货品不存在");
		ProductDTO dto = new ProductDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

	private void updateSaleStatus(List<String> codes, GoodsSaleStatus status) {
		codes.forEach(productCode -> {
			ProductEntity productEntity = productRepository.findOne(productCode);
			Validate.notNull(productEntity, "商品信息不存在");
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", productEntity.getGroupCode())
				.pass();

			productEntity.setSaleStatus(status);
			productRepository.save(productEntity);
		});
	}
}
