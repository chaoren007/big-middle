package com.morning.star.retail.application.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.application.GoodsApplication;
import com.morning.star.retail.application.ProductApplication;
import com.morning.star.retail.application.ProductImgApplication;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.entity.GoodsEntity;
import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.entity.ProductImgEntity;
import com.morning.star.retail.entity.ProductInfo;
import com.morning.star.retail.entity.repository.*;
import com.morning.star.retail.enums.BusOpcEnum;
import com.morning.star.retail.enums.GoodsSaleStatus;
import com.morning.star.retail.enums.ProductBusType;
import com.morning.star.retail.enums.ProductImgType;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.helper.SupplierService;
import com.morning.star.retail.helper.vo.StoreInfo;
import com.morning.star.retail.listener.mq.BusPushGoodsQueue;
import com.morning.star.retail.listener.mq.WmsGoodPullQueue;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GoodsApplicationImpl implements GoodsApplication {

	private Logger log = LoggerFactory.getLogger(GoodsApplicationImpl.class);
	@Autowired
	private GoodsRepository goodsRepository;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductSpecRepository productSpecRepository;

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private UnitsRepository unitsRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UpcCodeRepository upcCodeRepository;

	@Autowired
	private StoreService storeService;

	@Autowired
	private ProductApplication productApplication;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ProductImgApplication productImgApplication;

	@Autowired
	private WmsGoodPullQueue wmsGoodPullQueue;

	@Autowired
	private BusPushGoodsQueue busPushGoodsQueue;


	@Autowired
	private ProductImgRepository productImgRepository;


	@Override
	public void makePrice(String goodsCode, BigDecimal price) {
		GoodsEntity entity = goodsRepository.findOne(goodsCode);
		Validate.isTrue(entity != null, "店铺商品不存在");
		new UserPermission(UserUtils.currentUser())
			.tag("groupCode", entity.getProductInfo().getGroupCode())
			.tag("storeCode", entity.getStoreCode())
			.msg("该商品不允许改价：" + goodsCode)
			.pass();

		entity.getProductInfo().setSalePrice(price);
		goodsRepository.save(entity);
	}

	@Override
	public void onSale(String code) {
		GoodsEntity entity = goodsRepository.findOne(code);
		Validate.isTrue(entity != null, "店铺商品不存在");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getStoreCode())
			.msg("该商品不允许上架：" + code)
			.pass();

		entity.setSaleStatus(GoodsSaleStatus.ON_SALE);
		goodsRepository.save(entity);
	}

	@Override
	public void offSale(String code) {
		GoodsEntity entity = goodsRepository.findOne(code);
		Validate.isTrue(entity != null, "店铺商品不存在");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getStoreCode())
			.msg("该商品不允许下架：" + code)
			.pass();

		entity.setSaleStatus(GoodsSaleStatus.OFF_SALE);
		goodsRepository.save(entity);
	}


	@Override
	public String createStoreGoods(GoodsPullDTO goodsPullDTO) {
		Validate.notEmpty(goodsPullDTO.getGroupCode(), "集团编码不能为空");
		Validate.notEmpty(goodsPullDTO.getStoreCode(), "门店编码不能为空");
		String storeCode = goodsPullDTO.getStoreCode();
		String productCode = goodsPullDTO.getProductCode();

		GoodsEntity goodsEntity = goodsRepository.getByStoreCodeAndProductInfoProductCode(storeCode, productCode);

		Validate.isTrue(goodsEntity == null, "商品已引入：" + productCode);
		StoreInfo storeInfo = storeService.getByCode(storeCode);
		ProductEntity product = productRepository.findOne(productCode);
		Validate.notNull(product, "货品信息不存在");
		GoodsEntity entity = new GoodsEntity();
		entity.setGoodsCode(UniqueNoUtils.nextInc(UniqueNoUtils.UniqueNoType.G, productCode, 5));
		ProductInfo productInfo = new ProductInfo();
		BeanUtils.copy(product, productInfo);
		entity.setProductInfo(productInfo);
		entity.setGoodsName(productInfo.getProductName());
		entity.setStoreCode(storeCode);
		entity.setStoreName(storeInfo.getStoreName());
		entity.getProductInfo().setCityId(storeInfo.getCityId());
		entity.getProductInfo().setCityName(storeInfo.getCityName());
		entity.setMarketStatus(product.getStatus());
		entity.setSaleStatus(GoodsSaleStatus.ON_SALE);


		productImgApplication.addForStore(productCode, storeCode, entity.getGoodsCode(), ProductImgType.ATLAS);
		productImgApplication.addForStore(productCode, storeCode, entity.getGoodsCode(), ProductImgType.INTRODUCE);
		goodsRepository.save(entity);


		//保存到wms
		GoodsWmsDTO wmsDTO = GoodsEntity.toWmsDTO(entity);
		wmsGoodPullQueue.send(wmsDTO);
//		productWmsFacade.add(wmsDTO);

		//同步到运营端
		BusProductDTO  busdto =toBusProductDTO(storeCode,product);
		busPushGoodsQueue.send(busdto);
		return entity.getGoodsCode();

	}

	private String newGoodsCode(String storeCode, String productCode) {
		return productCode + "_" + storeCode;
	}

	@Override
	@Transactional
	@com.morning.star.retail.validate.Validate
	public void batchPull(List<GoodsPullDTO> goodsPullDTOS) {
		Validate.notEmpty(goodsPullDTOS, "无引入货品数据");
		goodsPullDTOS.forEach(this::createStoreGoods);
	}

	@Override
	@com.morning.star.retail.validate.Validate
	public void addGoods(List<GoodsSubmitDTO> dtos) {
		Validate.notEmpty(dtos, "无添加货品数据");
		List<ProductSubmitDTO> productDTOs = new ArrayList<>();
		dtos.forEach(dto -> {
			//保存主数据
			ProductSubmitDTO productDTO = new ProductSubmitDTO();
			BeanUtils.copy(dto, productDTO);
			productDTOs.add(productDTO);
		});
		//保存主数据
		List<String> productCodeList = productApplication.add(productDTOs);

		//保存分公司商品数据
		ArrayList<GoodsPullDTO> goodsPullDTOS = new ArrayList<>();
		productCodeList.forEach(code -> {
			GoodsPullDTO goodsPullDTO = new GoodsPullDTO();
			goodsPullDTO.setGroupCode(dtos.get(0).getGroupCode());
			goodsPullDTO.setStoreCode(dtos.get(0).getStoreCode());
			goodsPullDTO.setProductCode(code);
			goodsPullDTOS.add(goodsPullDTO);
		});
		//保存分公司商品数据
		batchPull(goodsPullDTOS);
	}

	@Transactional
	@Override
	public void update(GoodsUpdateDTO dto) {
		GoodsEntity goodsEntity = goodsRepository.findOne(dto.getGoodsCode());
		Validate.notNull(goodsEntity, "商品信息不存在：" + dto.getGoodsCode());
		Validate.notEmpty(dto.getGroupCode(), "集团编码不能为空");
		Validate.notEmpty(dto.getStoreCode(), "门店编码不能为空");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", goodsEntity.getStoreCode())
			.msg("不允许更新该商品：" + dto.getGoodsCode())
			.pass();

		SupplierDTO supplierDTO = supplierService.get(dto.getSupplierCode(), dto.getGroupCode());
		Validate.notNull(supplierDTO, "供应商信息不存在:" + dto.getSupplierCode());
		goodsEntity.getProductInfo().setIconPath(dto.getIconPath());
		goodsEntity.getProductInfo().setSupplierCode(dto.getSupplierCode());
		goodsEntity.getProductInfo().setSupplierName(supplierDTO.getSupplierName());

		goodsEntity.getProductInfo().setCostPrice(dto.getCostPrice());
		goodsEntity.getProductInfo().setSalePrice(dto.getSalePrice());
		goodsEntity.getProductInfo().setOriginPlace(dto.getOriginPlace());

		productImgApplication.deleteByProductCode(dto.getGoodsCode(), dto.getGroupCode());

		productImgApplication.add(goodsEntity.getProductInfo().getGroupCode(), dto.getStoreCode(), goodsEntity.getProductInfo().getSapProductCode(), goodsEntity.getGoodsCode(),
			dto.getIconPath(),
			ProductImgType.ICON);
		productImgApplication.add(goodsEntity.getProductInfo().getGroupCode(), dto.getStoreCode(), goodsEntity.getProductInfo().getSapProductCode(), goodsEntity.getGoodsCode(),
			dto.getImgPaths(),
			ProductImgType.ATLAS);
		productImgApplication.add(goodsEntity.getProductInfo().getGroupCode(), dto.getStoreCode(), goodsEntity.getProductInfo().getSapProductCode(), goodsEntity.getGoodsCode(),
			dto.getIntroImgPaths(),
			ProductImgType.INTRODUCE);

		goodsRepository.save(goodsEntity);
	}

	@Override
	@Transactional
	public void syncGoods(String groupCode, String storeCode) {
		List<ProductEntity> productEntityList = productRepository.getByGroupCode(groupCode);
		if (productEntityList != null && productEntityList.size() > 0) {
			// 获取门店已同步的货品编码
			List<GoodsEntity> goodsEntityList = goodsRepository.getByStoreCode(storeCode);
			Set<String> productCodeSet = new HashSet<>();
			if (goodsEntityList != null && goodsEntityList.size() > 0) {
				goodsEntityList.forEach(e -> {
					if (StringUtils.isNotBlank(e.getProductInfo().getProductCode())) {
						productCodeSet.add(e.getProductInfo().getProductCode());
					}
				});
			}
			productEntityList.forEach(productEntity -> {
				String productCode = productEntity.getProductCode();
				if (productCodeSet.size() < 1 || !productCodeSet.contains(productCode)) {
					GoodsEntity entity = new GoodsEntity(newGoodsCode(storeCode, productCode));
					ProductInfo productInfo = new ProductInfo();
					BeanUtils.copy(productEntity, productInfo);
					entity.setProductInfo(productInfo);
					entity.setStoreCode(storeCode);
					entity.setMarketStatus(productEntity.getStatus());
					entity.setSaleStatus(GoodsSaleStatus.ON_SALE);
					entity.getProductInfo().setSalePrice(productEntity.getSalePrice());
					goodsRepository.save(entity);
				}
			});
		}
	}

	@Override
	public void syncProductInfo(ProductSyncGoodsDTO dto) {
		ProductEntity productEntity = productRepository.findOne(dto.getProductCode());
		List<GoodsEntity> goodsEntityList = goodsRepository.getByProductInfoGroupCodeAndProductInfoProductCode(dto.getGroupCode(), dto.getProductCode());
		if (goodsEntityList != null && goodsEntityList.size() > 0) {
			goodsEntityList.forEach(item -> {
				ProductInfo productInfo = item.getProductInfo();

				productInfo.setStatus(productEntity.getStatus());
				productInfo.setSupplierCode(productEntity.getSupplierCode());
				productInfo.setSupplierName(productEntity.getSupplierName());
				productInfo.setIconPath(productEntity.getIconPath());
				productInfo.setGuidePrice(productEntity.getGuidePrice());
				productInfo.setCostPrice(productEntity.getCostPrice());
				productInfo.setPurchasePrice(productEntity.getPurchasePrice());

				goodsRepository.save(item);
			});
		}
	}

	private BusProductDTO toBusProductDTO(String storeCode,ProductEntity product) {
		List<ProductImgEntity> productImgEntities = productImgRepository.getByProductCode(product.getProductCode());
		//主页图，单张
		StringBuffer pImgIndex = new StringBuffer();
		//轮播图，单或多张
		StringBuffer pImgs = new StringBuffer();
		//详情图，单或多张
		StringBuffer pImgDes = new StringBuffer();
		//详情图集合
		List<BusProductDTO.ProductList.PImgDessBean>  pImgDessBeans = new ArrayList<>();
		productImgEntities.forEach(e -> {
			if (ProductImgType.ICON.getCode().equals(e.getImgType().getCode())) {
				pImgIndex.append(e.getImgUri()+",");
			}
			if (ProductImgType.ATLAS.getCode().equals(e.getImgType().getCode())) {
				pImgs.append(e.getImgUri()+",");
			}
			if (ProductImgType.INTRODUCE.getCode().equals(e.getImgType().getCode())) {
				pImgDes.append(e.getImgUri()+",");
				BusProductDTO.ProductList.PImgDessBean bean = new BusProductDTO.ProductList.PImgDessBean();
				bean.setId(bean.getId()+1);
				bean.setImgUrl(e.getImgUri());
				pImgDessBeans.add(bean);
			}
		});
		log.info("==============发送消息到bus端===============");
		BusProductDTO bus = new BusProductDTO();


		bus.setOpc(BusOpcEnum.getEnum(storeCode).getTarget());
		bus.setpName(product.getProductName());
		bus.setSupplierName(product.getSupplierName());
		bus.setpCategId(product.getCategoryId3().toString());
		bus.setpCategName(product.getCategoryName3());
		bus.setCreatedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		bus.setIsFarm(0);
		bus.setpDes("");
		bus.setCreateor(storeCode);
		String spuCode = product.getSpuCode();
		if(spuCode==null||spuCode.isEmpty()){
			//单品
			bus.setProductType(ProductBusType.SINGLE.getCode());
			bus.setpCode(product.getProductCode());
			bus.setpImgIndex(pImgIndex.toString());
			bus.setpImgs(pImgs.toString());
			bus.setpImgDes(pImgDes.toString());
		}else{
			//多规格
			String[] split = product.getSpuInfo().split(";");
			List<BusProductDTO.ProductList.ProductParamListBean> paramListBeans = new ArrayList<>();
			for (String s : split) {
				BusProductDTO.ProductList.ProductParamListBean paramListBean = new BusProductDTO.ProductList.ProductParamListBean();
				String[] param = s.split(":");
				paramListBean.setParamName(param[0]);
				paramListBean.setParamValue(param[1]);
				paramListBeans.add(paramListBean);
			}
			List<BusProductDTO.ProductList> productLists = new ArrayList<>();
			List<BusProductDTO.ProductList.PImgDessBean> pings = new ArrayList<>();
			BusProductDTO.ProductList productList = new BusProductDTO.ProductList();
			productList.setpCode(product.getProductCode());
			productList.setpName(product.getProductName()+"系列");
			//
			productList.setpImgIndex(pImgIndex.toString());

			productList.setpImgs(pImgs.toString());
			productList.setpImgDes(pImgDes.toString());
			productList.setProductParamList(paramListBeans);
			productList.setpImgDess(pImgDessBeans);
			productLists.add(productList);

			bus.setProductType(ProductBusType.SERIES.getCode());
			bus.setpCode(spuCode);
			bus.setProductParamList(JSON.toJSONString(paramListBeans));
			bus.setProductList(productLists);
		}
		//	log.info(JSON.toJSONString(bus));
		return bus;
	}
}
