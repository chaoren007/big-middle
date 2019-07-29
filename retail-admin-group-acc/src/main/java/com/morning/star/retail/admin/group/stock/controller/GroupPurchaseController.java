package com.morning.star.retail.admin.group.stock.controller;

import com.morning.star.retail.admin.group.stock.controller.enums.PurchaseStatusEnum;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.PurchaseFacade;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group/purchase/")
@Api(tags = "采购单操作")
public class GroupPurchaseController extends AdminController {

    @Autowired
    private PurchaseFacade purchaseFacade;
    @Autowired
    private SupplierFacade supplierFacade;
    @Autowired
    private ProductFacade productFacade;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "提交采购单")
    @Validate
    @RequiresPermissions(value = {"purchase:add"})
    public WebBean<String> submitOrder(@RequestBody PurchaseSubmitDTO purchaseSubmitDTO) {
        AdminLoginContent login = getLoginAdmin();
        purchaseSubmitDTO.fillLoginUser(login);
        purchaseSubmitDTO.setIsDraft(0);
        purchaseSubmitDTO.setSubmitType(10);

        String result = purchaseFacade.submitOrder(purchaseSubmitDTO);
        if (StringUtils.isNotEmpty(result)) {
            return WebBean.ok(result);
        } else {
            return WebBean.fail(result);
        }
    }

//	@ApiOperation(value = "供应货品-根据upc查询")
//	@RequestMapping(value = "queryByUpc", method = RequestMethod.GET)
//	@RequiresPermissions(value = {"purchase:add"})
//	public WebBean<List<ProductForPurchaseDTO>> queryItemByUpc(@RequestParam @ApiParam(value = "商品UPC") String upcCode) {
//		AdminLoginContent login = getLoginAdmin();
//		ProductGetUpcDTO productGetUpcDTO = new ProductGetUpcDTO();
//		productGetUpcDTO.setGroupCode(login.getGroupCode());
//		productGetUpcDTO.setProductUpc(upcCode);
//		return WebBean.ok(productFacade.getByUpcForPurchase(productGetUpcDTO));
//	}

    @RequestMapping(value = "add/prepare", method = RequestMethod.POST)
    @ApiOperation(value = "提交采购单草稿")
    @Validate
    @RequiresPermissions(value = {"purchase:prepare_add"})
    public WebBean<String> prepareOrder(@RequestBody PurchaseSubmitDTO purchaseSubmitDTO) {
        AdminLoginContent login = getLoginAdmin();
        purchaseSubmitDTO.fillLoginUser(login);
        purchaseSubmitDTO.setIsDraft(1);
        purchaseSubmitDTO.setSubmitType(10);

        String result = purchaseFacade.submitOrder(purchaseSubmitDTO);
        return StringUtils.isNotEmpty(result) ? WebBean.ok(result) : WebBean.fail(result);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "更新采购单")
    @Validate
    @RequiresPermissions(value = {"purchase:update"})
    public WebBean<String> prepareOrder(@RequestBody PurchaseUpdateDTO purchaseUpdateDTO) {
        AdminLoginContent login = getLoginAdmin();
        purchaseUpdateDTO.setGroupCode(login.getGroupCode());

        String result = purchaseFacade.updateOrder(purchaseUpdateDTO);
        return StringUtils.isNotEmpty(result) ? WebBean.ok(result) : WebBean.fail(result);
    }

    @RequestMapping(value = "audit/fail", method = RequestMethod.POST)
    @ApiOperation(value = "采购单审核不通过")
    @Validate
    @RequiresPermissions(value = {"purchase:audit_fail"})
    public WebBean<Integer> auditFail(@RequestBody PurchaseAuditDTO purchaseOrderDTO) {
        purchaseOrderDTO.setStatus(PurchaseStatusEnum.AUDIT_REJECT.getCode());

        Integer returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

        return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
    }

    @RequestMapping(value = "audit/success", method = RequestMethod.POST)
    @ApiOperation(value = "采购单审核通过")
    @Validate
    @RequiresPermissions(value = {"purchase:audit_success"})
    public WebBean<Integer> auditSuccess(@RequestBody PurchaseAuditDTO purchaseOrderDTO) {
        purchaseOrderDTO.setStatus(PurchaseStatusEnum.AUDIT_SUCCESS.getCode());
        Integer returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

        return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
    }
/*

	@RequestMapping(value = "audit/boss", method = RequestMethod.POST)
	@ApiOperation(value = "采购单BOSS审核通过")
	@Validate
	@RequiresPermissions(value = {"purchase:audit_boss"})
	public WebBean<Integer> bossAudit(@RequestBody PurchaseAuditDTO purchaseOrderDTO) {
		AdminLoginContent login = getLoginAdmin();

		purchaseOrderDTO.setStatus(PurchaseStatusEnum.BOSS_AUDIT.getCode());
		Integer returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

		return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
	}
*/

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "采购单草稿删除")
    @Validate
    @RequiresPermissions(value = {"purchase:delete"})
    public WebBean<Integer> deletePurchase(@RequestBody PurchaseDeleteDTO purchaseDeleteDTO) {
        Integer returnVale = purchaseFacade.deletePurchase(purchaseDeleteDTO);
        return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ApiOperation(value = "采购单查询")
    @RequiresPermissions(value = {"purchase:list"})
    public WebBean<PageBean<PurchaseOrderSimpleDTO>> queryOrder(PurchaseQueryDTO searchDTO) {
        AdminLoginContent login = getLoginAdmin();
        searchDTO.setGroupCode(login.getGroupCode());

        return WebBean.ok(purchaseFacade.queryOrder(searchDTO));
    }

    @RequestMapping(value = "get/detail-code", method = RequestMethod.GET)
    @ApiOperation(value = "采购单详情")
    @Validate
    @RequiresPermissions(value = {"purchase:detail"})
    public WebBean<PurchaseOrderDTO> getPurchaseByCode(@ApiParam(value = "采购单号") PurchaseGetDTO purchaseGetDTO) {
        AdminLoginContent login = getLoginAdmin();

        purchaseGetDTO.setGroupCode(login.getGroupCode());
        PurchaseOrderDTO returnVale = purchaseFacade.getPurchaseByCode(purchaseGetDTO);
        /*SupplierDTO supplier = supplierFacade.get(returnVale.getSupplierCode(), login.getGroupCode());
        if (supplier != null) {
            String contract = supplier.getContact();
            returnVale.setSupplierContract(contract);
        }*/
        return WebBean.ok(returnVale);

    }
/*
	@RequestMapping(value = "verify/store-code/supplier-code", method = RequestMethod.GET)
	@ApiOperation(value = "校验供应商是否提供该商品")
	public WebBean verifyStoreCodeAndSupplierCode(@RequestParam @ApiParam(value = "商品编号") String productCode,
	                                              @RequestParam @ApiParam(value = "供应商编号") String supplierCode) {
		SupplierQueryDTO supplierQueryDTO = new SupplierQueryDTO();
		supplierQueryDTO.setSupplierCode(supplierCode);
		//supplierQueryDTO.setProductCode(productCode);

		SupplierItemDTO item = supplierFacade.getItem(supplierQueryDTO);
		return item == null ? WebBean.fail("该商品与供应商不存在采购关系") : WebBean.ok();
	}

	@RequestMapping(value = "verify", method = RequestMethod.POST)
	@ApiOperation(value = "校验采购单中供应商是否提供该商品")
	public WebJsonBean verifySupplierItem(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
		List<String> list = purchaseFacade.checkSupplierRelationship(purchaseOrderDTO);
		return (list == null || list.size() <= 0) ? success() : fail(list);
	}

	@RequestMapping(value = "import", method = RequestMethod.POST)
	@ApiOperation(value = "批量导入采购单")
	@RequiresPermissions(value = {"purchase:import"})
	public WebJsonBean importPurchaseOrder(MultipartFile importFile) {
		AdminLoginContent login = getLoginAdmin();
		List<PurchaseImportVO> purchaseImportVOList = new ExcelUtil<>(PurchaseImportVO.class).readXLSData(importFile, OriginalType.XLSX);
		List<PurchaseImportDTO> purchaseImportDTOList = new ArrayList<>(purchaseImportVOList.size());
		purchaseImportVOList.forEach(e -> {
			PurchaseImportDTO purchaseImportDTO = new PurchaseImportDTO();
			BeanUtils.copy(e, purchaseImportDTO);
			purchaseImportDTO.setGroupCode(login.getGroupCode());

			purchaseImportDTOList.add(purchaseImportDTO);
		});
		this.purchaseFacade.batchImport(purchaseImportDTOList);

		return success();
	}

	@RequestMapping(value = "import/detail", method = RequestMethod.POST)
	@ApiOperation(value = "导入采购单详情")
	@RequiresPermissions(value = {"purchase:detail_import"})
	public WebBean<List<PurchaseOrderDetailDTO>> importPurchaseDetail(MultipartFile importFile, String purchaseOrderCode) {
		AdminLoginContent login = getLoginAdmin();
		List<PurchaseDetailImportVO> purchaseDetailImportVOList = new ExcelUtil<>(PurchaseDetailImportVO.class).readXLSData(importFile, OriginalType.XLSX);

		List<PurchaseDetailImportDTO> purchaseDetailImportDTOS = new ArrayList<>(purchaseDetailImportVOList.size());
		purchaseDetailImportVOList.forEach(e -> {
			PurchaseDetailImportDTO purchaseDetailImportDTO = new PurchaseDetailImportDTO();
			BeanUtils.copy(e, purchaseDetailImportDTO);

			purchaseDetailImportDTOS.add(purchaseDetailImportDTO);
		});

		PurchaseImportUpdateDTO dto = new PurchaseImportUpdateDTO();
		dto.setGroupCode(login.getGroupCode());
		dto.setPurchaseCode(purchaseOrderCode);
		dto.setPurchaseDetailImportDTOS(purchaseDetailImportDTOS);

		return WebBean.ok(this.purchaseFacade.importDetail(dto));
	}

	@RequestMapping(value = "export/detail", method = RequestMethod.GET)
	@ApiOperation(value = "导出采购单详情")
	@RequiresPermissions(value = {"purchase:detail_export"})
	public WebJsonBean exportPurchaseDetail(String purchaseOrderCode, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		PurchaseOrderDTO orderVO = this.purchaseFacade.getPurchaseByCode(new PurchaseGetDTO(login.getGroupCode(), purchaseOrderCode));
		List<PurchaseOrderDetailDTO> list = orderVO.getOrderDetail();
		List<PurchaseDetailExportVO> detailDTOList = new ArrayList<>();
		list.forEach(detailVO -> {
			PurchaseDetailExportVO detailDTO = new PurchaseDetailExportVO();
			BeanUtils.copy(detailVO, detailDTO);
			detailDTOList.add(detailDTO);
		});
		try {
			new ExcelUtil<>(PurchaseDetailExportVO.class).writeToHttpResponse(detailDTOList, "导出采购单详情列表.xlsx", "采购单列表", response);
		} catch (Exception e) {
			throw new RuntimeException("导出采购单详情错误", e);
		}
		return success();
	}

	@RequestMapping(value = "export/detail-all", method = RequestMethod.GET)
	@ApiOperation(value = "导出明细列表")
	@RequiresPermissions(value = {"purchase:all_detail_export"})
	public WebJsonBean exportPurchaseDetailAll(PurchaseQueryDTO searchDTO, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());
		searchDTO.setBusinessCode(getQueryBusinessAccountCode(searchDTO.getBusinessCode()));
		searchDTO.setVcontainerCode(getQueryVConatnerAccountCode(searchDTO.getVcontainerCode()));

		PageBean<PurchaseOrderDetailDTO> pageBean = this.purchaseFacade.queryPurchaseDetail(searchDTO);
		List<PurchaseOrderDetailDTO> list = pageBean.getRecord();
		List<PurchaseDetailListExportVO> detailDTOList = new ArrayList<>();
		list.forEach(detailVO -> {
			PurchaseDetailListExportVO detailDTO = new PurchaseDetailListExportVO();
			BeanUtils.copy(detailVO, detailDTO);
			detailDTOList.add(detailDTO);
		});
		try {
			new ExcelUtil<>(PurchaseDetailListExportVO.class).writeToHttpResponse(detailDTOList, "导出明细列表.xlsx", "采购单列表", response);
		} catch (Exception e) {
			throw new RuntimeException("导出采购单详情错误", e);
		}
		return success();
	}

	@RequestMapping(value = "export", method = RequestMethod.GET)
	@ApiOperation(value = "导出采购单")
	@RequiresPermissions(value = {"purchase:export"})
	public WebJsonBean exportPurchaseOrder(PurchaseQueryDTO searchDTO, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());
		searchDTO.setBusinessCode(getQueryBusinessAccountCode(searchDTO.getBusinessCode()));
		searchDTO.setVcontainerCode(getQueryVConatnerAccountCode(searchDTO.getVcontainerCode()));
		searchDTO.setPageNo(1);
		searchDTO.setPageSize(Integer.MAX_VALUE);
		PageBean<PurchaseOrderSimpleDTO> orderList = purchaseFacade.queryOrder(searchDTO);

		List<PurchaseOrderSimpleDTO> list = orderList.getRecord();
		List<PurchaseExportVO> detailDTOList = new ArrayList<>();
		list.forEach(e -> {
			PurchaseExportVO detailDTO = new PurchaseExportVO();
			BeanUtils.copy(e, detailDTO);
			detailDTO.setCreateTime(e.getCreateTime() == null ? "" : DateUtil.toString(e.getCreateTime()));

			detailDTOList.add(detailDTO);
		});
		try {
			new ExcelUtil<>(PurchaseExportVO.class).writeToHttpResponse(detailDTOList, "导出采购单列表.xlsx", "采购单列表", response);
		} catch (Exception e) {
			throw new RuntimeException("导出采购单详情错误", e);
		}
		return success();
	}


	@RequestMapping(value = "query/rpt", method = RequestMethod.GET)
	@ResponseBody
	public WebJsonBean queryPurchaseDetailRpt(PurchaseQueryDTO searchDTO) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());
		searchDTO.setStoreCode(login.getStoreCode());

		Object returnVale = purchaseFacade.queryPurchaseDetailRpt(searchDTO);

		return success(returnVale);

	}


	@RequestMapping(value = "export/rpt", method = RequestMethod.GET)
	@ResponseBody
	public WebJsonBean exportPurchaseDetailRpt(PurchaseQueryDTO searchDTO, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());
		searchDTO.setStoreCode(login.getStoreCode());
		searchDTO.setPageNo(1);
		searchDTO.setPageSize(Integer.MAX_VALUE);
		PageBean<PurchaseOrderRptDTO> orderList = purchaseFacade.queryPurchaseDetailRpt(searchDTO);

		List<PurchaseOrderRptDTO> list = orderList.getRecord();
		List<PurchaseDetailRptExportVO> detailDTOList = new ArrayList<>();
		list.forEach(e -> {
			PurchaseDetailRptExportVO detailDTO = new PurchaseDetailRptExportVO();

			BeanUtils.copy(e, detailDTO);
			detailDTO.setPurchaseTime(e.getPurchaseTime() == null ? "" : DateUtil.toString(e.getPurchaseTime()));
			detailDTOList.add(detailDTO);
		});
		try {
			new ExcelUtil<>(PurchaseDetailRptExportVO.class).writeToHttpResponse(detailDTOList, "导出采购明细报表.xls", "采购单明细", response);
		} catch (Exception e) {
			throw RetailException.of(PurchaseErrorCode.PURCHASE_EXPORT_EXCEL_ERROR);
		}
		return success();
	}
*/
}
