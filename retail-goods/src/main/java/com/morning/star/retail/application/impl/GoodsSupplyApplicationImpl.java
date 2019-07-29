package com.morning.star.retail.application.impl;

import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.application.GoodsSupplyApplication;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.entity.*;
import com.morning.star.retail.entity.repository.*;
import com.morning.star.retail.enums.CategoryEnum;
import com.morning.star.retail.enums.GoodsAttributeEnum;
import com.morning.star.retail.enums.GoodsSupplyStatus;
import com.morning.star.retail.enums.ProductImgType;
import com.morning.star.retail.facade.SubmitSystem;
import com.morning.star.retail.facade.assembler.GoodsSupplyAssembler;
import com.morning.star.retail.facade.dto.ProductSpecDTO;
import com.morning.star.retail.facade.dto.supply.*;
import com.morning.star.retail.helper.AddressService;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.helper.SupplierService;
import com.morning.star.retail.helper.vo.AddressInfo;
import com.morning.star.retail.helper.vo.StoreInfo;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ethan
 * @create_time 2019/3/8 17:53
 */
@Service
@Transactional
public class GoodsSupplyApplicationImpl implements GoodsSupplyApplication {

	private Logger logger = LoggerFactory.getLogger(GoodsSupplyApplicationImpl.class);

	@Autowired
	private GoodsSupplyRepository goodsSupplyRepository;
	@Autowired
	private GoodsSupplySetRepository goodsSupplySetRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private UnitsRepository unitsRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductSpecRepository productSpecRepository;
	@Autowired
	private ProductImgRepository productImgRepository;

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private StoreService storeService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private AddressService addressService;

	@Override
	public GoodsSupplyDTO submit(GoodsSupplySubmitDTO dto, GoodsSupplyStatus status) {
		// 提交编码
		String code = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.GSC);
		List<GoodsSupplyEntity> existEntityList = new ArrayList<>();
		if (StringUtils.isNotBlank(dto.getGoodsSupplyCode())) {
			code = dto.getGoodsSupplyCode();
			existEntityList = goodsSupplyRepository.findByGoodsSupplyCode(code);
			Validate.isTrue(existEntityList != null && existEntityList.size() > 0,
				"修改商品不存在");
			existEntityList.forEach(e -> {
				if (SubmitSystem.SUPPLIER.getSource().equals(e.getOwnSystem())) {
					Validate.isTrue(SubmitSystem.SUPPLIER.equals(dto.getSubmitSystem()) &&
							dto.getSupplierCode().equals(e.getSupplierCode()),
						"不能修改该供应商商品");
				}
				if (SubmitSystem.STORE.getSource().equals(e.getOwnSystem())) {
					Validate.isTrue(SubmitSystem.STORE.equals(dto.getSubmitSystem()),
						"不能修改该分公司商品");
				}
				Validate.isTrue(!GoodsSupplyStatus.OPEN_GROUP.equals(e.getSupplyStatus()),
					"开团中不允许修改");
			});
		}
		// 版本编码
		String versionCode = UniqueNoUtils.nextInc(UniqueNoUtils.UniqueNoType.PC, 10);
		// 多规格编码
		String spuCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.SPU);

		// 基础数据校验
//		Validate.isTrue(CommodityTypeEnum.from(dto.getCommodityType()) != null,
//			"商品类型不存在:%s", dto.getCommodityType());
//		Validate.isTrue(StorageTypeEnum.from(dto.getStorageType()) != null,
//			"商品存储类型不存在:%s", dto.getStorageType());
		Validate.isTrue(CategoryEnum.exitCode(dto.getCategoryType()),
			"存货类别不存在：" + dto.getCategoryType());
		Validate.isTrue(GoodsAttributeEnum.exitCode(dto.getGoodsAttribute()),
			"商品属性不存在：" + dto.getGoodsAttribute());

		// 校验单位信息
		UnitsEntity unitsEntity = unitsRepository.findOne(Long.parseLong(dto.getUnitsId()));
		Validate.isTrue(unitsEntity != null, "单位信息不存在:%s", dto.getUnitsId());

		// 校验供应商信息
		SupplierDTO supplierDTO;
		if (SubmitSystem.SUPPLIER.equals(dto.getSubmitSystem())) {
			supplierDTO = supplierService.get(dto.getSupplierCode());
		} else {
			supplierDTO = new SupplierDTO();
			supplierDTO.setSupplierCode("default");
			supplierDTO.setSupplierName("默认供应商");
		}
		Validate.notNull(supplierDTO, "供应商信息不存在:%s" + dto.getSupplierCode());

		// 校验分类信息
		List<CategoryEntity> categoryEntities = checkAndGetCategory(Long.parseLong(dto.getCategoryId()));

		// 校验品牌信息
		BrandEntity brandEntity = null;
		if (StringUtils.isNotBlank(dto.getBrandId())) {
			brandEntity = brandRepository.findOne(Long.parseLong(dto.getBrandId()));
		}

		UserInfo userInfo = UserUtils.currentUser();
		List<GoodsSupplyEntity> entityList = new ArrayList<>(dto.getDetail().size());
		List<ProductSpecEntity> productSpecEntityList = new ArrayList<>();
		// 根据提交信息和校验信息生成最终入库数据
		builderBySubmit(dto, status, userInfo, entityList, existEntityList, productSpecEntityList,
			code, versionCode, spuCode, supplierDTO, categoryEntities, brandEntity, unitsEntity);

		// 删除历史图片
		List<ProductImgEntity> existImgEntityList = productImgRepository.getBySapProductCode(code);
		productImgRepository.delete(existImgEntityList);
		productImgRepository.save(getImgBySubmit(dto, userInfo.getTag("groupCode"), code));

		// 规格信息更新
		List<ProductSpecEntity> existSpecEntityList = productSpecRepository.getByProductCodeIn(entityList.stream()
			.map(GoodsSupplyEntity::getProductCode).collect(Collectors.toList()));
		productSpecRepository.delete(existSpecEntityList);
		productSpecRepository.save(productSpecEntityList);

		// 多规格商品
		if ("PP".equals(entityList.get(0).getProductType())) {
			// 设置主规格信息
			GoodsSupplyEntity mainEntity = new GoodsSupplyEntity();
			BeanUtils.copy(entityList.get(0), mainEntity);
			mainEntity.setUpcCode(null);
			// 多规格商品  主商品编码重新设置
			mainEntity.setProductCode("PP" + mainEntity.getProductCode());
			mainEntity.setMainSpu(1);
			mainEntity.setAreaDetail(Collections.emptyList());
			Set<String> mainSupplyCityIds = entityList.stream()
				.flatMap(entity -> new HashSet<>(Arrays.asList(entity.getSupplyCityIds().split(","))).stream())
				.collect(Collectors.toSet());
			Set<String> mainSupplyCityNames = entityList.stream()
				.flatMap(entity -> new HashSet<>(Arrays.asList(entity.getSupplyCityNames().split(","))).stream())
				.collect(Collectors.toSet());
			mainEntity.setSupplyCityIds(String.join(",", mainSupplyCityIds));
			mainEntity.setSupplyCityNames(String.join(",", mainSupplyCityNames));
			// 计算主信息
			BigDecimal stockNum = BigDecimal.ZERO;
			BigDecimal salesNum = BigDecimal.ZERO;
			BigDecimal priceMax = entityList.get(0).getPriceMax();
			BigDecimal priceMin = entityList.get(0).getPriceMin();
			for (GoodsSupplyEntity entity : entityList) {
				stockNum = stockNum.add(entity.getStockNum());
				salesNum = salesNum.add(entity.getSalesNum());
				if (priceMax.compareTo(entity.getPriceMax()) < 0) {
					priceMax = entity.getPriceMax();
				}
				if (priceMin.compareTo(entity.getPriceMin()) > 0) {
					priceMin = entity.getPriceMin();
				}
			}
			mainEntity.setStockNum(stockNum);
			mainEntity.setSalesNum(salesNum);
			mainEntity.setPriceMax(priceMax);
			mainEntity.setPriceMin(priceMin);
			entityList.add(mainEntity);
		} else {
			entityList.get(0).setMainSpu(1);
		}


		// 删除覆盖记录
		goodsSupplyRepository.delete(existEntityList);
		goodsSupplyRepository.save(entityList);

		// 添加流水记录
		addLog(entityList, StringUtils.isNoneBlank(dto.getGoodsSupplyCode()) ? "修改编辑" : "提交创建", true);
		GoodsSupplyDTO goodsSupplyDTO = GoodsSupplyAssembler.builderDTO(entityList, false);
		goodsSupplyDTO.setImgPaths(dto.getImgPaths());
		goodsSupplyDTO.setIntroImgPaths(dto.getIntroImgPaths());
		return goodsSupplyDTO;
	}

	/**
	 * 根据提交信息和校验信息生成最终入库数据
	 *
	 * @param dto                   提交数据
	 * @param status                提交状态
	 * @param userInfo              提交人信息
	 * @param entityList            需生成的商品数据
	 * @param existEntityList       已存在商品数据
	 * @param productSpecEntityList 规格数据
	 * @param code                  提交编码
	 * @param versionCode           版本号
	 * @param spuCode               规格编码
	 * @param supplierDTO           供应商信息
	 * @param categoryEntities      分类信息
	 * @param brandEntity           品牌信息
	 * @param unitsEntity           单位信息
	 */
	private void builderBySubmit(GoodsSupplySubmitDTO dto,
	                             GoodsSupplyStatus status,
	                             UserInfo userInfo,
	                             List<GoodsSupplyEntity> entityList,
	                             List<GoodsSupplyEntity> existEntityList,
	                             List<ProductSpecEntity> productSpecEntityList,
	                             String code,
	                             String versionCode,
	                             String spuCode,
	                             SupplierDTO supplierDTO,
	                             List<CategoryEntity> categoryEntities,
	                             BrandEntity brandEntity,
	                             UnitsEntity unitsEntity) {
		for (GoodsSupplySpuSubmitDTO e : dto.getDetail()) {
			GoodsSupplyEntity entity = new GoodsSupplyEntity();
			BeanUtils.copy(dto, entity);
			entity.setGroupCode(userInfo.getTag("groupCode"));
			entity.setGroupName(userInfo.getTag("groupName"));
			entity.setStoreCode(userInfo.getTag("storeCode"));
			entity.setStoreName(userInfo.getTag("storeName"));
			// 提交方
			entity.setOwnSystem(dto.getSubmitSystem().getSource());

			// 如果提交单品编码则获取历史数据
			String productCode;
			Optional<GoodsSupplyEntity> existEntity = Optional.empty();
			if (StringUtils.isNotBlank(e.getProductCode())) {
				productCode = e.getProductCode();
				existEntity = existEntityList.stream()
					.filter(obj -> obj.getProductCode().equals(productCode))
					.findFirst();
				Validate.isTrue(existEntity.isPresent(), "单品编码不存在：%s", productCode);
			} else {
				String newProductCode = UniqueNoUtils.nextInc(UniqueNoUtils.UniqueNoType.PC, String.valueOf(dto.getCategoryId()), 4)
					.replace(UniqueNoUtils.UniqueNoType.PC.toString(), "");
				// 如果编码已经存在继续递增获取
				while (goodsSupplyRepository.existsByProductCode(newProductCode)) {
					newProductCode = UniqueNoUtils.nextInc(UniqueNoUtils.UniqueNoType.PC, String.valueOf(dto.getCategoryId()), 4)
						.replace(UniqueNoUtils.UniqueNoType.PC.toString(), "");
				}
				productCode = newProductCode;
			}

			// 多规格货品 保存相关规格信息
			entity.setProductType("SP");
			if (e.getProductSpecInfo() != null && e.getProductSpecInfo().size() > 0) {
				String spuInfo = ProductSpecDTO.formStr(e.getProductSpecInfo());

				entity.setSpuCode(spuCode);
				entity.setSpuInfo(spuInfo);

				// 添加规格数据
				e.getProductSpecInfo().forEach(spec -> {
					ProductSpecEntity productSpecEntity = new ProductSpecEntity();
					BeanUtils.copy(spec, productSpecEntity);
					productSpecEntity.setProductCode(productCode);
					productSpecEntity.setSpuCode(spuCode);
					productSpecEntity.setGroupCode(userInfo.getTag("groupCode"));
					productSpecEntity.setIsMain(1);
					productSpecEntityList.add(productSpecEntity);
				});
				entity.setProductType("PP");
			}

			entity.setProductCode(productCode);
			entity.setProductName(dto.getProductName());

			// 设置添加商品默认属性值
			entity.setSpuInfo(ProductSpecDTO.formStr(e.getProductSpecInfo()));
			// 供应商
			entity.setSupplierCode(supplierDTO.getSupplierCode());
			entity.setSupplierName(supplierDTO.getSupplierName());
			// 分类
			entity.setCategoryId1(categoryEntities.get(0).getCategoryId());
			entity.setCategoryName1(categoryEntities.get(0).getCategoryName());
			entity.setCategoryId2(categoryEntities.get(1).getCategoryId());
			entity.setCategoryName2(categoryEntities.get(1).getCategoryName());
			entity.setCategoryId3(categoryEntities.get(2).getCategoryId());
			entity.setCategoryName3(categoryEntities.get(2).getCategoryName());
			if (dto.getCategorySpecInfo() != null) {
				entity.setCategorySpuInfo(ProductSpecDTO.formStr(dto.getCategorySpecInfo()));
			}
			// 品牌
			if (brandEntity != null) {
				entity.setBrandId(brandEntity.getId());
				entity.setBrandName(brandEntity.getBrandName());
			}
			// 单位
			entity.setUnitsId(unitsEntity.getId());
			entity.setUnitsName(unitsEntity.getUnitsName());

			entity.setUpcCode(dto.getUpcCode());

			entity.setGoodsSupplyCode(code);
			entity.setVersionCode(versionCode);
			entity.setGoodsName(dto.getProductName());
			entity.setStockNum(e.getStockNum());
			entity.setStockWarningNum(e.getStockWarningNum());
			if (existEntity.isPresent()) {
				entity.setSalesNum(existEntity.get().getSalesNum());
			} else {
				entity.setSalesNum(BigDecimal.ZERO);
			}

			// 区域设置信息
			String supplyCityIds = e.getAreaDetail().stream()
				.map(area -> String.join(",", area.getCityIds()))
				.collect(Collectors.joining(","));
			String supplyCityNames = e.getAreaDetail().stream()
				.map(area -> String.join(",", area.getCityNames()))
				.collect(Collectors.joining(","));
			List<BigDecimal> priceList = e.getAreaDetail().stream()
				.map(GoodsSupplySetSubmitDTO::getPrice)
				.collect(Collectors.toList());
			BigDecimal priceMax = priceList.stream().max(BigDecimal::compareTo).orElse(null);
			BigDecimal priceMin = priceList.stream().min(BigDecimal::compareTo).orElse(null);
			entity.setSupplyCityIds(supplyCityIds);
			entity.setSupplyCityNames(supplyCityNames);
			entity.setPriceMax(priceMax);
			entity.setPriceMin(priceMin);
			// 设置初始状态
			entity.setSupplyStatus(status);
			entity.setSupplyStatusDesc(status.getDesc());
			entity.setMainSpu(0);

			// 区域分配详情
			List<GoodsSupplySetEntity> setEntityList = new ArrayList<>(e.getAreaDetail().size());
			Integer areaSubmitGroup = 0;
			for (GoodsSupplySetSubmitDTO areaDetail : e.getAreaDetail()) {
				areaSubmitGroup += 1;
				for (String cityId : areaDetail.getCityIds()) {
					AddressInfo addressInfo = addressService.getById(Long.valueOf(cityId));
					Validate.isTrue(addressInfo != null, "供货城市不存在：" + cityId);
					Validate.isTrue(addressInfo.getAddressLevel() == 2, "编码不属于城市：" + cityId);

					GoodsSupplySetEntity goodsSupplySetEntity = new GoodsSupplySetEntity();
					goodsSupplySetEntity.setGoodsSupplyCode(code);
					goodsSupplySetEntity.setProductCode(productCode);
					goodsSupplySetEntity.setPrice(areaDetail.getPrice());
					goodsSupplySetEntity.setTotalNum(areaDetail.getTotalNum());
					goodsSupplySetEntity.setVersionCode(versionCode);
					goodsSupplySetEntity.setSupplierCode(supplierDTO.getSupplierCode());
					goodsSupplySetEntity.setSupplierName(supplierDTO.getSupplierName());

					goodsSupplySetEntity.setProvinceId(Long.valueOf(addressInfo.getPath().split(",")[1]));
					goodsSupplySetEntity.setProvinceName(addressInfo.getPathCh().split(",")[0]);
					goodsSupplySetEntity.setCityId(addressInfo.getAddressId());
					goodsSupplySetEntity.setCityName(addressInfo.getAddressName());
					goodsSupplySetEntity.setRegionCode(addressInfo.getRegionCode());
					goodsSupplySetEntity.setRegionName(addressInfo.getRegionName());
					goodsSupplySetEntity.setSubmitGroup(areaSubmitGroup);
					setEntityList.add(goodsSupplySetEntity);
				}
			}
			entity.setAreaDetail(setEntityList);

			entityList.add(entity);
		}
	}

	private List<ProductImgEntity> getImgBySubmit(GoodsSupplySubmitDTO dto, String groupCode, String supplyCode) {
		List<ProductImgEntity> imgEntityList = new ArrayList<>();
		if (StringUtils.isNotBlank(dto.getIconPath())) {
			imgEntityList.addAll(Arrays.stream(dto.getIconPath().split(","))
				.map(imgStr -> new ProductImgEntity(groupCode, "", supplyCode,
					supplyCode, imgStr, ProductImgType.ICON, 1))
				.collect(Collectors.toList()));
		}
		if (StringUtils.isNotBlank(dto.getImgPaths())) {
			imgEntityList.addAll(Arrays.stream(dto.getImgPaths().split(","))
				.map(imgStr -> new ProductImgEntity(groupCode, "", supplyCode,
					supplyCode, imgStr, ProductImgType.ATLAS, 1))
				.collect(Collectors.toList()));
		}
		if (StringUtils.isNotBlank(dto.getIntroImgPaths())) {
			imgEntityList.addAll(Arrays.stream(dto.getIntroImgPaths().split(","))
				.map(imgStr -> new ProductImgEntity(groupCode, "", supplyCode,
					supplyCode, imgStr, ProductImgType.INTRODUCE, 1))
				.collect(Collectors.toList()));
		}

		return imgEntityList;
	}

	/**
	 * 校验分类信息，将分类信息填写进货品信息中
	 */
	private List<CategoryEntity> checkAndGetCategory(Long cid) {
		List<CategoryEntity> categoryList = new ArrayList<>();
		while (cid != null && cid > 0) {
			CategoryEntity category1 = categoryRepository.getByCategoryId(cid);
			Validate.notNull(category1, "分类不存在：" + cid);
			categoryList.add(category1);
			cid = category1.getParentId();
		}
		Collections.reverse(categoryList);
		return categoryList;
	}

	@Override
	public void audit(GoodsSupplyAuditDTO dto, GoodsSupplyStatus status) {
		List<GoodsSupplyEntity> entityList;
		if (StringUtils.isNotBlank(dto.getGoodsSupplyCode())) {
			entityList = goodsSupplyRepository.findByGoodsSupplyCode(dto.getGoodsSupplyCode());
		} else {
			entityList = goodsSupplyRepository.findByGoodsSupplyCodeIn(dto.getGoodsSupplyCodeSet());
		}
		Validate.isTrue(entityList != null && entityList.size() > 0,
			"审核信息不存在：%s", dto.getGoodsSupplyCode());
		UserInfo userInfo = UserUtils.currentUser();

		// 审核状态期望的当前操作状态
		Set<GoodsSupplyStatus> expectStatusSet = new HashSet<>();
		String logRemark = "";
		checkAuditPermission(userInfo, entityList, dto.getSubmitSystem(), dto.getAuditPermission());

		switch (status) {
			case NO_PASS: {
				expectStatusSet.add(GoodsSupplyStatus.SUBMIT);
				logRemark = "审核驳回";
				break;
			}
			case ON_SALE: {
				if (SubmitSystem.SUPPLIER.equals(dto.getSubmitSystem())) {
					expectStatusSet.add(GoodsSupplyStatus.OFF_SALE);
					logRemark = "供应商上架";
				}
				if (SubmitSystem.STORE.equals(dto.getSubmitSystem()) || SubmitSystem.GROUP.equals(dto.getSubmitSystem())) {
					expectStatusSet.add(GoodsSupplyStatus.OFF_SALE);
					expectStatusSet.add(GoodsSupplyStatus.SUBMIT);
					logRemark = "审核上架";
				}
				break;
			}
			case OFF_SALE: {
				expectStatusSet.add(GoodsSupplyStatus.ON_SALE);
				logRemark = "下架";
				break;
			}
			default: {
				break;
			}
		}
		Validate.isTrue(expectStatusSet.size() > 0, "状态错误：%s", status.getDesc());
		for (GoodsSupplyEntity e : entityList) {
			Validate.isTrue(expectStatusSet.contains(e.getSupplyStatus()),
				"信息状态错误：%s", e.getSupplyStatus().getDesc());
			e.setSupplyStatus(status);
			e.setSupplyStatusDesc(status.getDesc());
			if (StringUtils.isNotBlank(dto.getReason())) {
				e.setRemark(dto.getReason());
			}
		}
		goodsSupplyRepository.save(entityList);
		addLog(entityList, logRemark, false);
	}

	@Override
	public void auditGroup(GoodsSupplyAuditGroupDTO dto, GoodsSupplyStatus status) {
		Validate.isTrue(GoodsSupplyStatus.ON_SALE.equals(status) ||
				GoodsSupplyStatus.OPEN_GROUP.equals(status),
			"提交状态错误：" + status.getDesc());

		GoodsSupplyEntity entity = goodsSupplyRepository.findByProductCode(dto.getProductCode());
		Validate.isTrue(entity != null, "商品不存在：" + dto.getProductCode());
		Validate.isTrue(GoodsSupplyStatus.ON_SALE.equals(entity.getSupplyStatus()) ||
				GoodsSupplyStatus.OPEN_GROUP.equals(entity.getSupplyStatus()),
			"商品状态错误：" + entity.getSupplyStatus().getDesc());

		List<GoodsSupplyEntity> entityList = goodsSupplyRepository.findByGoodsSupplyCode(entity.getGoodsSupplyCode());
		UserInfo userInfo = UserUtils.currentUser();
		checkAuditPermission(userInfo, entityList, dto.getSubmitSystem(), 0);

		// 是否所有团购关闭
		boolean isAllClose = true;

		List<GoodsSupplySetEntity> areaDetail = goodsSupplySetRepository.findByGoodsSupplyCode(entity.getGoodsSupplyCode());
		// 开团状态修改的供应城市列表
		List<GoodsSupplySetEntity> changeAreaDetailList = new ArrayList<>();

		// 设置城市的开团状态
		for (GoodsSupplySetEntity areaItem : areaDetail) {
			if (dto.getProductCode().equals(areaItem.getProductCode()) &&
				areaItem.getCityId().equals(Long.valueOf(dto.getCityId())) &&
				!status.equals(areaItem.getSupplyStatus())) {
				areaItem.setSupplyStatus(status);

				// 添加修改记录
				changeAreaDetailList.add(areaItem);
			}
			if (GoodsSupplyStatus.OPEN_GROUP.equals(areaItem.getSupplyStatus())) {
				isAllClose = false;
			}
		}

		if (GoodsSupplyStatus.OPEN_GROUP.equals(status) ||
			(GoodsSupplyStatus.ON_SALE.equals(status) && isAllClose)) {
			entityList.forEach(item -> {
				if (!status.equals(item.getSupplyStatus())) {
					item.setSupplyStatus(status);
				}
			});
		}

		if (changeAreaDetailList.size() > 0) {
			goodsSupplyRepository.save(entityList);
			String logRemark = GoodsSupplyStatus.OPEN_GROUP.equals(status) ? "开团" : "结团";
			logRemark += "(" + dto.getProductCode() + ")：" + changeAreaDetailList.get(0).getCityName();

			addLog(entityList, logRemark, false);
			addDetailLog(changeAreaDetailList, logRemark);
		}
	}

	private void checkAuditPermission(UserInfo userInfo, List<GoodsSupplyEntity> entityList,
	                                  SubmitSystem submitSystem,
	                                  Integer auditPermission) {
		switch (submitSystem) {
			case GROUP: {
				for (GoodsSupplyEntity entity : entityList) {
					Validate.isTrue(entity.getGroupCode().equals(userInfo.getTag("groupCode")),
						"不属于该集团商品");
				}
				break;
			}
			case STORE: {
				StoreInfo storeInfo = storeService.getByCode(userInfo.getTag("storeCode"));
				Validate.isTrue(storeInfo != null, "门店信息不存在");
				if (Integer.valueOf(1).equals(auditPermission)) {
					entityList.stream().filter(entity -> Integer.valueOf(1).equals(entity.getMainSpu()))
						.forEach(entity -> {
							List<String> cityList = Arrays.asList(entity.getSupplyCityIds().split(","));
							Validate.isTrue(cityList.contains(String.valueOf(storeInfo.getCityId())),
								"供货城市不包括当前城市");
						});
				} else {
					entityList.stream().filter(entity -> Integer.valueOf(1).equals(entity.getMainSpu()))
						.forEach(entity -> {
							List<String> cityList = Arrays.asList(entity.getSupplyCityIds().split(","));
							Validate.isTrue(cityList.size() == 1 && cityList.contains(String.valueOf(storeInfo.getCityId())),
								"不能审核多供货城市商品");
						});
				}
				break;
			}
			case SUPPLIER: {
				for (GoodsSupplyEntity entity : entityList) {
					Validate.isTrue(entity.getSupplierCode().equals(userInfo.getTag("supplierCode")),
						"不属于该供应商商品");
				}
				break;
			}
			case BUS: {
				break;
			}
			default: {
				throw new IllegalArgumentException("提交方不存在：" + submitSystem.getSource());
			}
		}

	}

	@Override
	public void saleOutStock(List<GoodsSupplyStockReduceDTO> dtoList) {
		Map<String, GoodsSupplyEntity> entityMap = new HashMap<>();
		for (GoodsSupplyStockReduceDTO dto : dtoList) {
			GoodsSupplyEntity entity = entityMap.get(dto.getProductCode());
			if (entity == null) {
				entity = goodsSupplyRepository.findByProductCode(dto.getProductCode());
			}
			Validate.isTrue(entity != null, "商品不存在：%s", dto.getProductCode());

			Optional<GoodsSupplySetEntity> existAreaEntity = entity.getAreaDetail().stream()
				.filter(obj -> obj.getCityId().equals(dto.getCityId()))
				.findFirst();
			if (existAreaEntity.isPresent()) {
				GoodsSupplySetEntity areaEntity = existAreaEntity.get();
				areaEntity.setSalesNum(areaEntity.getSalesNum().add(dto.getNum()));
				areaEntity.setTotalNum(areaEntity.getTotalNum().subtract(dto.getNum()));

				entity.setSalesNum(entity.getSalesNum().add(dto.getNum()));
				entity.setStockNum(entity.getSalesNum().subtract(dto.getNum()));
			} else {
				throw new IllegalArgumentException("供货城市不存在：" + dto.getCityId());
			}

			entityMap.put(dto.getProductCode(), entity);
		}

		goodsSupplyRepository.save(entityMap.values());
		addLog(entityMap.values(), "销售出库", true);
	}

	@Override
	@Transactional
	public void remove(GoodsSupplyDelDTO dto) {
		List<GoodsSupplyEntity> entityList;
		if (StringUtils.isNotBlank(dto.getGoodsSupplyCode())) {
			entityList = goodsSupplyRepository.findByGoodsSupplyCode(dto.getGoodsSupplyCode());
		} else {
			entityList = goodsSupplyRepository.findByGoodsSupplyCodeIn(dto.getGoodsSupplyCodeSet());
		}
		if (entityList != null && entityList.size() > 0) {
			UserInfo userInfo = UserUtils.currentUser();
			Validate.isTrue(AccountLevelEnum.SUPPLIER.getCode().equals(userInfo.getTag("accountLevel")),
				"非供应商不允许操作");
			entityList.forEach(entity -> {
				Validate.isTrue(entity.getSupplierCode().equals(userInfo.getTag("supplierCode")),
					"删除信息错误：%s", entity.getGoodsSupplyCode());
				// 指定允许删除的状态
				Validate.isTrue(GoodsSupplyStatus.DRAFT.equals(entity.getSupplyStatus()) ||
						GoodsSupplyStatus.SUBMIT.equals(entity.getSupplyStatus()) ||
						GoodsSupplyStatus.OFF_SALE.equals(entity.getSupplyStatus()) ||
						GoodsSupplyStatus.NO_PASS.equals(entity.getSupplyStatus()),
					"删除数据状态错误：%s", entity.getSupplyStatus().getDesc());
			});
			goodsSupplyRepository.delete(entityList);
			addLog(entityList, "删除数据", false);
		}
	}

	/**
	 * 添加流水记录
	 */
	private void addLog(Collection<GoodsSupplyEntity> entityList, String remark, boolean addDetail) {
		entityList.forEach(e -> {
			waterRepository.save(e, GoodsSupplyWaterEntity.class, remark);
			if (addDetail) {
				addDetailLog(e.getAreaDetail(), remark);
			}
		});
	}

	private void addDetailLog(Collection<GoodsSupplySetEntity> entityList, String remark) {
		entityList.forEach(detail ->
			waterRepository.save(detail, GoodsSupplySetWaterEntity.class, remark)
		);
	}
}
