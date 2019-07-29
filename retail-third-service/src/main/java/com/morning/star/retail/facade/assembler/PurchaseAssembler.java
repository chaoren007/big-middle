package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.dto.PurchaseWmsInfoDTO;
import com.morning.star.retail.facade.dto.PurchaseDetailWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseSubmitWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseWmsDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.wms.Getorder;
import com.wms.Getorderdet;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseAssembler {

	public PurchaseWmsInfoDTO transform(PurchaseWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * custprd	单据编号	字符		　	是	否	　
		 * supplyno	供应商编码	字符		　	　	否	　
		 * isyk	越库标示	字符				否	1-越库/3-正常
		 * apptype	单据类型	字符				否	PO-采购入库单
		 * closeflag	作废标示	字符				否	D-作废/I-插入
		 * purdate	单据日期	日期		　	　	否	　
		 * predate	预到货日期	日期		　	　	是	　
		 * pretime	预到货时间	日期		　	　	是	　
		 * operater	制单人	字符		　	　	否	　
		 * cust_tel	联系电话	字符				是
		 * faxnum	传真	字符				是
		 * remark	备注	字符				是
		 * deptid	部门/柜组	字符				是
		 * yrstore	收货仓库	字符		　	　	否
		 * Billtype	促销标示	字符				否	Y-是/N-否
		 * Custno	货主	字符				否
		 * storeno	物流中心编码	字符				是	格式建议01/02
		 */
		Getorder getorder = new Getorder();
		getorder.setCustprd(new JAXBElement<>(new QName("custprd"), String.class, dto.getPurchaseInCode()));
		getorder.setSupplyno(new JAXBElement<>(new QName("supplyno"), String.class, dto.getSupplierCode()));
		getorder.setIsyk(new JAXBElement<>(new QName("isyk"), String.class, "3"));

		getorder.setApptype(new JAXBElement<>(new QName("apptype"), String.class, dto.getPushType()));
		getorder.setCloseflag(new JAXBElement<>(new QName("closeflag"), String.class, dto.getFlag()));
		getorder.setPurdate(new JAXBElement<>(new QName("purdate"), String.class, dto.getCreateTime()));

		dto.setPreReceiptDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		getorder.setPurdate(new JAXBElement<>(new QName("purdate"), String.class, dto.getPreReceiptDate().split(" ")[0]));
		getorder.setPretime(new JAXBElement<>(new QName("pretime"), String.class, dto.getPreReceiptDate()));
		getorder.setPredate(new JAXBElement<>(new QName("predate"), String.class, dto.getPreReceiptDate().split(" ")[0]));
		getorder.setOperater(new JAXBElement<>(new QName("operater"), String.class, dto.getOperatorName()));
		getorder.setYrstore(new JAXBElement<>(new QName("yrstore"), String.class, dto.getWarehouseCode()));
		getorder.setBilltype(new JAXBElement<>(new QName("billtype"), String.class, "N"));
		getorder.setCustno(new JAXBElement<>(new QName("custno"), String.class, dto.getStoreCode()));

		List<Getorder> list = new ArrayList<>();
		list.add(getorder);

		/**
		 * 字段名	名称	类型	宽度	精度	是否主键	为空	缺省值
		 * custprd	单据编号	字符			是	否	　
		 * crowno	行号	整数			是	否	　
		 * incode	商品编码	字符			是	否	　
		 * fname	商品名称	字符				否
		 * unit	最小配送单位	字符			　	否	　
		 * packunit	最大单位	字符				是
		 * specs	规格	字符				是
		 * packqty	箱含量	整数			　	是	1
		 * packs	箱数	整数			　	否	1
		 * qty	数量	实数			　	否	1
		 * inprc	单价	实数			　	是	0
		 * iamt	金额	实数			　	是	0
		 * blargess	赠品	字符				是	　Y-是/N否
		 * batchno	批号	字符				是
		 * barcode	主条码	字符				是
		 * Custno	货主	字符				否
		 */
		List<PurchaseDetailWmsDTO> detail = dto.getDetail();
		List<Getorderdet> getorderdets = new ArrayList<>();
		int index = 1;
		for (PurchaseDetailWmsDTO e : detail) {
			Getorderdet getorderdet = new Getorderdet();
			getorderdet.setCustprd(new JAXBElement<>(new QName("custprd"), String.class, e.getPurchaseInCode()));
			getorderdet.setCrowno(index);
			getorderdet.setIncode(new JAXBElement<>(new QName("incode"), String.class, e.getProductCode()));
			getorderdet.setFname(new JAXBElement<>(new QName("fname"), String.class, e.getProductName()));
			getorderdet.setUnit(new JAXBElement<>(new QName("unit"), String.class, e.getUnitsName()));
			getorderdet.setPacks(e.getQty().doubleValue());
			getorderdet.setQty(e.getQty().doubleValue());
			getorderdet.setCustno(new JAXBElement<>(new QName("custno"), String.class, e.getStoreCode()));
			getorderdets.add(getorderdet);
			index += 1;
		}

		PurchaseWmsInfoDTO purchaseWmsInfoDTO = new PurchaseWmsInfoDTO();
		purchaseWmsInfoDTO.setGetorder(list);
		purchaseWmsInfoDTO.setGetorderdets(getorderdets);

		return purchaseWmsInfoDTO;
	}

	/**
	 * 采购提交数据转化为采购数据
	 */
	public PurchaseWmsDTO transform(PurchaseSubmitWmsDTO dto) {
		PurchaseWmsDTO purchaseWmsDTO = new PurchaseWmsDTO();
		BeanUtils.copy(dto, purchaseWmsDTO);

		purchaseWmsDTO.setDetail(dto.getDetail().stream()
			.map(e -> {
				PurchaseDetailWmsDTO detail = new PurchaseDetailWmsDTO();
				BeanUtils.copy(e, detail);

				detail.setPurchaseInCode(dto.getPurchaseInCode());
				detail.setStoreCode(dto.getStoreCode());
				return detail;
			})
			.collect(Collectors.toList()));

		return purchaseWmsDTO;
	}
}
