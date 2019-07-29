package com.morning.star.retail.admin.group.goods.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.admin.group.goods.controller.enums.ProductMarketStatus;
import com.morning.star.retail.admin.group.goods.controller.vo.ProductExportVO;
import com.morning.star.retail.admin.group.goods.controller.vo.ProductInfoImportVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.enums.GoodsSalesTypeEnum;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/group/")
@Api(tags = "集团货品相关操作")
public class GroupProductController extends AdminController {
	private Logger logger = LoggerFactory.getLogger(GroupProductController.class);

	@Autowired
	private ProductFacade productFacade;

	@Autowired
	private GoodsAdminFacade storeGoodsFacade;

	@Autowired
    private AddressFacade addressFacade;

	@ApiOperation(value = "后台生成货品编码")
	@RequestMapping(value = "product/code", method = RequestMethod.GET)
	public WebBean<String> nextProductCode() {
		return WebBean.ok(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PC));
	}

	@ApiOperation(value = "后台批量生成货品编码")
	@RequestMapping(value = "product/codes", method = RequestMethod.GET)
	public WebBean<List<String>> nextProductCodes(@RequestParam @ApiParam(value = "生成个数") Integer codeNum) {
		if (codeNum <= 0) {
			return WebBean.ok();
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < codeNum; i++) {
			result.add(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PC));
		}

		return WebBean.ok(result);
	}

	@ApiOperation(value = "添加集团货品")
	@RequestMapping(value = "product/batch-add", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = {"product:add"})
	public WebBean<Void> batchAdd(@RequestBody List<ProductSubmitDTO> dtos) {
		AdminLoginContent login = getLoginAdmin();

		dtos.forEach(e -> e.setGroupCode(login.getGroupCode()));
		productFacade.addProduct(dtos);
		return WebBean.ok();
	}

	@ApiOperation(value = "集团货品引入")
	@RequestMapping(value = "product/batch-pull", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> batchPull(@RequestBody ProductPullDTO dto) {
		AdminLoginContent login = getLoginAdmin();

		dto.setGroupCode(login.getGroupCode());
		productFacade.pullProduct(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "获取集团货品详情")
	@RequestMapping(value = "product/get-detail-code", method = RequestMethod.GET)
	@RequiresPermissions(value = {"product:detail"})
	public WebBean<ProductDTO> getDetailByCode(@RequestParam @ApiParam(required = true, value = "货品编码") String productCode) {
		AdminLoginContent login = getLoginAdmin();

		ProductGetDTO dto = new ProductGetDTO();
		dto.setGroupCode(login.getGroupCode());
		dto.setProductCode(productCode);
		return WebBean.ok(productFacade.getDetail(dto));
	}

	@ApiOperation(value = "获取集团货品详情By UPC")
	@RequestMapping(value = "product/get-detail-upc", method = RequestMethod.GET)
	@RequiresPermissions(value = {"product:detail"})
	public WebBean<List<ProductDTO>> getGoodsByUpc(@RequestParam @ApiParam(required = true, value = "货品UPC") String upcCode) {
		AdminLoginContent login = getLoginAdmin();

		ProductGetUpcDTO getUpcDTO = new ProductGetUpcDTO();
		getUpcDTO.setProductUpc(upcCode);
		getUpcDTO.setGroupCode(login.getGroupCode());
		return WebBean.ok(productFacade.getByUpc(getUpcDTO));
	}

	@ApiOperation(value = "获取集团货品详情By UPC和productName")
	@RequestMapping(value = "product/query-list", method = RequestMethod.GET)
	public WebBean<List<ProductDTO>> queryList(@ApiParam(required = true, value = "查询参数") ProductQueryDTO queryDTO) {
		AdminLoginContent login = getLoginAdmin();
		queryDTO.setGroupCode(login.getGroupCode());
		return WebBean.ok(productFacade.queryList(queryDTO));
	}

	@ApiOperation(value = "查询集团货品详情列表")
	@RequestMapping(value = "product/query", method = RequestMethod.GET)
	@RequiresPermissions(value = {"product:list"})
	public WebBean<PageBean<ProductDTO>> pageList(@ApiParam(required = true, value = "查询参数") ProductQueryDTO goodsDTO) {
		AdminLoginContent login = getLoginAdmin();
		goodsDTO.setGroupCode(login.getGroupCode());
		return WebBean.ok(productFacade.queryProduct(goodsDTO));
	}

	@ApiOperation(value = "查询城市商品列表")
	@RequestMapping(value = "/product/city-list", method = RequestMethod.GET)
	@RequiresPermissions(value = "product:list")
	public WebBean<PageBean<GoodsDTO>> page(GoodsQueryDTO goodsQueryDTO) {
		goodsQueryDTO.setGroupCode(getLoginAdmin().getGroupCode());
		return WebBean.ok(storeGoodsFacade.queryGoodsForCity(goodsQueryDTO));
	}

	@ApiOperation(value = "获取城市商品详情")
	@RequestMapping(value = "/goods/get-city-detail", method = RequestMethod.GET)
	@RequiresPermissions(value = "product:list")
	public WebBean<GoodsDTO> detail(@RequestParam @ApiParam(value = "商品编码") String goodsCode) {
		GoodsDTO dto = storeGoodsFacade.getGoods(goodsCode);
		return WebBean.ok(dto);
	}

    @ApiOperation(value = "获取城市信息列表")
    @RequestMapping(value = "/product/city-info-list", method = RequestMethod.GET)
    public WebBean<List<AddressDTO>> city() {
        return WebBean.ok(addressFacade.getAllCity());
    }

	@ApiOperation(value = "更新集团货品信息")
	@RequestMapping(value = "product/edit", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = {"product:update"})
	public WebBean<Void> updateGoods(@RequestBody List<ProductUpdateDTO> dtos) {
		AdminLoginContent login = getLoginAdmin();
		dtos.forEach(e -> e.setGroupCode(login.getGroupCode()));
		productFacade.updateProduct(dtos);
		return WebBean.ok();
	}

	@ApiOperation(value = "集团货品上市状态")
	@RequestMapping(value = "product/on-mark", method = RequestMethod.POST)
	@RequiresPermissions(value = {"product:on_mark", "product:batch_mark"}, logical = Logical.OR)
	public WebBean<Void> batchOnMark(@RequestBody @ApiParam(value = "操作货品编码，多个逗号隔开") String productCodes) {
		productFacade.onMarket(Arrays.asList(productCodes.split(",")));
		return WebBean.ok();
	}

	@ApiOperation(value = "集团货品下市状态")
	@RequestMapping(value = "product/off-mark", method = RequestMethod.POST)
	@RequiresPermissions(value = {"product:off_mark", "product:batch_mark"}, logical = Logical.OR)
	public WebBean<Void> batchOffMark(@RequestBody @ApiParam(value = "操作货品编码，多个逗号隔开") String productCodes) {
		productFacade.offMarket(Arrays.asList(productCodes.split(",")));
		return WebBean.ok();
	}

	@ApiOperation(value = "集团货品上架状态")
	@RequestMapping(value = "product/on-sale", method = RequestMethod.POST)
	@RequiresPermissions(value = {"product:on_sale", "product:batch_sale"}, logical = Logical.OR)
	public WebBean<Void> batchOnSale(@RequestBody @ApiParam(value = "操作货品编码，多个逗号隔开") String productCodes) {
		productFacade.onSale(Arrays.asList(productCodes.split(",")));
		return WebBean.ok();
	}

	@ApiOperation(value = "集团货品下架状态")
	@RequestMapping(value = "product/off-sale", method = RequestMethod.POST)
	@RequiresPermissions(value = {"product:off_sale", "product:batch_sale"}, logical = Logical.OR)
	public WebBean<Void> batchOffSale(@RequestBody @ApiParam(value = "操作货品编码，多个逗号隔开") String productCodes) {
		productFacade.offSale(Arrays.asList(productCodes.split(",")));
		return WebBean.ok();
	}


	@ApiOperation(value = "批量导入商品信息")
	@RequestMapping(value = "product/import", method = RequestMethod.POST)
	@RequiresPermissions(value = {"product:import"})
	public WebBean<Void> importGoods(MultipartFile importFile) {
		AdminLoginContent login = getLoginAdmin();
		List<ProductInfoImportVO> productImportVOS = new ExcelUtil<>(ProductInfoImportVO.class).readXLSData(importFile, OriginalType.XLSX);

		List<ProductImportDTO> productImportDTOS = new ArrayList<>(productImportVOS.size());
		productImportVOS.forEach(e -> {
			ProductImportDTO productImportDTO = e.transform();
			productImportDTO.setGroupCode(login.getGroupCode());
			productImportDTOS.add(productImportDTO);
		});

		productFacade.submitImportProduct(productImportDTOS);
		return WebBean.ok();
	}

	@ApiOperation(value = "导出商品信息")
	@RequestMapping(value = "product/export", method = RequestMethod.GET)
	@RequiresPermissions(value = {"product:export"})
	public void exportGoods(ProductQueryDTO queryGroupGoodsDTO, HttpServletResponse response) {
		logger.info("------------ exportGoods ------------ start");
		AdminLoginContent login = getLoginAdmin();
		queryGroupGoodsDTO.setGroupCode(login.getGroupCode());
		queryGroupGoodsDTO.setPageNo(1);
		queryGroupGoodsDTO.setPageSize(Integer.MAX_VALUE);
		PageBean<ProductDTO> goodsByPage = productFacade.queryProduct(queryGroupGoodsDTO);

		List<ProductExportVO> list = new ArrayList<>(goodsByPage.getRecord().size());
		goodsByPage.getRecord().forEach(e -> {
			ProductExportVO productExportVO = new ProductExportVO();
			BeanUtils.copy(e, productExportVO);
			productExportVO.setStatus(ProductMarketStatus.get(e.getStatus()).getDesc());
			list.add(productExportVO);
		});
		try {
			new ExcelUtil<>(ProductExportVO.class).writeToHttpResponse(list, "导出商品.xlsx", "商品", response);
		} catch (Exception e) {
			throw new RuntimeException("导出货品错误", e);
		}
	}

	@RequestMapping(value = "product/sales-type", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<Map<Integer, String>>> listSalesType() {
		return WebBean.ok(GoodsSalesTypeEnum.list());
	}

}