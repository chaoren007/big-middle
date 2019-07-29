package com.morning.star.retail.admin.goods.controller;

import com.morning.star.retail.admin.goods.vo.GoodsExportVO;
import com.morning.star.retail.admin.goods.vo.GoodsImportVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.enums.GoodsSalesTypeEnum;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ethan, kimhuhg
 */

@RestController
@RequestMapping("/api")
@Api(tags = "门店商品")
public class GoodsController extends AdminController {
	@Autowired
	private GoodsAdminFacade storeGoodsFacade;

	@Autowired
	private ProductFacade productFacade;

	@Autowired
	private AddressFacade addressFacade;

	@ApiOperation(value = "查询集团货品详情列表")
	@RequestMapping(value = "goods/product", method = RequestMethod.GET)
	public WebBean<PageBean<ProductDTO>> pageList(@ApiParam(required = true, value = "查询参数") ProductQueryDTO goodsDTO) {
		AdminLoginContent login = getLoginAdmin();
		goodsDTO.setGroupCode(login.getGroupCode());
		return WebBean.ok(productFacade.queryProduct(goodsDTO));
	}

	/*@ApiOperation(value = "同步集团货品数据")
	@RequestMapping(value = "/goods/sync", method = RequestMethod.POST)
	@RequiresPermissions(value = "goods:group_sync")
	public WebBean<Void> sync() {
		AdminLoginContent login = getLoginAdmin();
		storeGoodsFacade.syncGoods(login.getGroupCode(), login.getStoreCode());
		return WebBean.ok();
	}*/


	@ApiOperation(value = "引入货品数据")
	@RequestMapping(value = "/goods/batch-pull", method = RequestMethod.POST)
	@RequiresPermissions(value = "goods:batch_pull")
	public WebBean<Void> batchPull(@RequestBody List<GoodsPullDTO> dtos) {
		AdminLoginContent login = getLoginAdmin();
		dtos.forEach(e -> {
			e.setGroupCode(login.getGroupCode());
			e.setStoreCode(login.getStoreCode());
		});
		storeGoodsFacade.batchPull(dtos);
		return WebBean.ok();
	}

	@ApiOperation(value = "获取引入货品详情")
	@RequestMapping(value = "/goods/get-product-detail", method = RequestMethod.GET)
	@RequiresPermissions(value = {"goods:batch_pull"})
	public WebBean<ProductDTO> getDetailByCode(@RequestParam @ApiParam(required = true, value = "货品编码") String productCode) {
		AdminLoginContent login = getLoginAdmin();
		ProductGetDTO dto = new ProductGetDTO();
		dto.setGroupCode(login.getGroupCode());
		dto.setProductCode(productCode);
		return WebBean.ok(productFacade.getDetail(dto));
	}

	/*@ApiOperation(value = "绑定柜组")
	@RequestMapping(value = "/goods/bind-container", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = "goods:bind_container")
	public WebBean<Void> bindContainer(@RequestBody GoodsBindContainerDTO dto) {
		AdminLoginContent login = getLoginAdmin();

		dto.setGroupCode(login.getGroupCode());
		dto.setStoreCode(login.getStoreCode());

		storeGoodsFacade.bindContainer(dto);
		return WebBean.ok();
	}*/

	@ApiOperation(value = "添加门店商品")
	@RequestMapping(value = "/goods/batch-add", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = "goods:batch_add")
	public WebBean<Void> batchAdd(@RequestBody List<GoodsSubmitDTO> dtos) {
		AdminLoginContent login = getLoginAdmin();
		dtos.forEach(e -> {
			e.setGroupCode(login.getGroupCode());
			e.setStoreCode(login.getStoreCode());
		});
		storeGoodsFacade.addGoods(dtos);
		return WebBean.ok();
	}

	@ApiOperation(value = "修改门店商品")
	@RequestMapping(value = "/goods/update", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = "goods:update")
	public WebBean<Void> batchUpdate(@RequestBody GoodsUpdateDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());
		dto.setStoreCode(login.getStoreCode());
		storeGoodsFacade.update(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "查询门店商品")
	@RequestMapping(value = "/goods/query", method = RequestMethod.GET)
	@RequiresPermissions(value = "goods:list")
	public WebBean<PageBean<GoodsDTO>> page(GoodsQueryDTO goodsQueryDTO) {
		goodsQueryDTO.setStoreCode(getLoginAdmin().getStoreCode());
		goodsQueryDTO.setGroupCode(getLoginAdmin().getGroupCode());
		return WebBean.ok(storeGoodsFacade.queryGoods(goodsQueryDTO));
	}

	@ApiOperation(value = "查询商品引入列表")
	@RequestMapping(value = "goods/pull", method = RequestMethod.GET)
	@RequiresPermissions(value = {"goods:list"})
	public WebBean<PageBean<ProductPullInfoDTO>> pull(@ApiParam(required = true, value = "查询参数") ProductQueryDTO goodsDTO) {
		AdminLoginContent login = getLoginAdmin();
		goodsDTO.setGroupCode(login.getGroupCode());
		goodsDTO.setStoreCode(login.getStoreCode());
		return WebBean.ok(productFacade.queryForPull(goodsDTO));
	}

	@ApiOperation(value = "获取城市信息列表")
	@RequestMapping(value = "/goods/city-info-list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> city() {
		return WebBean.ok(addressFacade.getAllCity());
	}

	@ApiOperation(value = "获取门店商品详情")
	@RequestMapping(value = "/goods/get-detail-code", method = RequestMethod.GET)
	@RequiresPermissions(value = "goods:detail")
	public WebBean<GoodsDTO> detail(@RequestParam @ApiParam(value = "商品编码") String goodsCode) {
		GoodsDTO dto = storeGoodsFacade.getGoods(goodsCode);
		return WebBean.ok(dto);
	}

	@ApiOperation(value = "通过UPC获取门店商品详情")
	@RequestMapping(value = "/goods/get-detail-upc", method = RequestMethod.GET)
	@RequiresPermissions(value = "goods:detail")
	public WebBean<List<GoodsDTO>> getGoodsByUpc(@RequestParam @ApiParam(value = "UPC编码") String upcCode) {
		return WebBean.ok(storeGoodsFacade.getGoodsByUpc(getLoginAdmin().getStoreCode(), upcCode));
	}

	@ApiOperation(value = "通过UPC和ProductName获取门店商品详情")
	@RequestMapping(value = "/goods/query-list", method = RequestMethod.GET)
	public WebBean<List<GoodsDTO>> getGoodsByUpc(GoodsQueryDTO queryDTO) {
		AdminLoginContent login = getLoginAdmin();
		queryDTO.setGroupCode(login.getGroupCode());
		queryDTO.setStoreCode(login.getStoreCode());
		return WebBean.ok(storeGoodsFacade.queryList(queryDTO));
	}

	@ApiOperation(value = "导出商品数据")
	@RequestMapping(value = "/goods/export", method = RequestMethod.GET)
	@RequiresPermissions(value = "goods:export")
	public void exportGoods(GoodsQueryDTO goodsQueryDTO, HttpServletResponse response) {
		goodsQueryDTO.setStoreCode(getLoginAdmin().getStoreCode());
		PageBean<GoodsDTO> goodsByPage = storeGoodsFacade.queryGoods(goodsQueryDTO);
		List<GoodsExportVO> list = new ArrayList<>(goodsByPage.getRecord().size());
		goodsByPage.getRecord().forEach(e -> {
			GoodsExportVO goodsExportVO = new GoodsExportVO();
			BeanUtils.copyProperties(e, goodsExportVO);
			list.add(goodsExportVO);
		});

		try {
			new ExcelUtil<>(GoodsExportVO.class).writeToHttpResponse(list, "导出商品.xlsx", "商品", response);
		} catch (Exception e) {
			throw new RuntimeException("上传图片异常", e);
		}
	}

	@ApiOperation(value = "批量导入商品信息")
	@RequestMapping(value = "/goods/import", method = RequestMethod.POST)
	@RequiresPermissions(value = "goods:import")
	public WebBean<Void> importGoods(MultipartFile importFile) {
		AdminLoginContent login = getLoginAdmin();
		List<GoodsImportVO> goodsImportVOS = new ExcelUtil<>(GoodsImportVO.class).readXLSData(importFile, OriginalType.XLSX);

		List<GoodsPullDTO> goodsPullDTOS = new ArrayList<>(goodsImportVOS.size());
		goodsImportVOS.forEach(e -> {
			GoodsPullDTO goodsPullDTO = new GoodsPullDTO();
			BeanUtils.copyProperties(e, goodsPullDTO);
			goodsPullDTO.setGroupCode(login.getGroupCode());
			goodsPullDTO.setStoreCode(login.getStoreCode());
			goodsPullDTOS.add(goodsPullDTO);
		});

		storeGoodsFacade.batchPull(goodsPullDTOS);
		return WebBean.ok();
	}

	@RequestMapping(value = "/goods/sales-type", method = RequestMethod.GET)
	@ApiOperation(value = "获取商品销售类型")
	public WebBean<List<Map<Integer, String>>> listSalesType() {
		return WebBean.ok(GoodsSalesTypeEnum.list());
	}

}
