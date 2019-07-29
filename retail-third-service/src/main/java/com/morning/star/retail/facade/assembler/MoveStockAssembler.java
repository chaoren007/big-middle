package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.dto.MoveStockWmsInfoDTO;
import com.morning.star.retail.dto.OutStockWmsInfoDTO;
import com.morning.star.retail.facade.dto.MoveStockDetailWmsDTO;
import com.morning.star.retail.facade.dto.MoveStockWmsDTO;
import com.morning.star.retail.facade.dto.OutStockDetailWmsDTO;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;
import com.wms.Getorder;
import com.wms.Getorderdet;
import com.wms.Putorder;
import com.wms.Putorderdet;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class MoveStockAssembler {

	public MoveStockWmsInfoDTO transform(MoveStockWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * custprd	单据编号	字符		　	是	否	　
		 * supplyno	客户	字符		　	　	否	　
		 * apptype	单据类型	字符				否	默认1
		 * closeflag	作废标示	字符				否	D-作废/I-插入
		 * purdate	单据日期	日期		　	　	否	　
		 * predate	预到货日期	日期		　	　	否	　
		 * pretime	预到货时间	日期		　	　	否	　
		 * operater	制单人	字符		　	　	否	　
		 * cust_tel	联系电话	字符				是
		 * faxnum	传真	字符				是
		 * remark	备注	字符				是
		 * deptid	部门/柜组	字符				是
		 * yrstore	移入仓库	字符		　	　	否
		 * ycstoreno	移出仓库
		 * Custno	货主	字符	8			否
		 * storeno	物流中心编码	字符	2			否	格式建议01/02
		 */
		Getorder getorder = new Getorder();
		getorder.setCustprd(new JAXBElement<>(new QName("custprd"),String.class, dto.getPushCode()));
		getorder.setApptype(new JAXBElement<>(new QName("apptype"),String.class, dto.getPushType()));
		getorder.setCloseflag(new JAXBElement<>(new QName("closeflag"),String.class, dto.getFlag()));
		getorder.setPurdate(new JAXBElement<>(new QName("purdate"),String.class, dto.getCreateTime().split(" ")[0]));


//		getorder.setPredate(new JAXBElement<>(new QName("purdate"),String.class, dto.getCreateTime().split(" ")[0]));
//		getorder.setPretime(new JAXBElement<>(new QName("purdate"),String.class, dto.getCreateTime()));


		getorder.setOperater(new JAXBElement<>(new QName("operater"),String.class, dto.getOperatorName()));
		getorder.setCustTel(new JAXBElement<>(new QName("cust_tel"),String.class, dto.getPhone()));
		getorder.setRemark(new JAXBElement<>(new QName("remark"),String.class, dto.getRemark()));
		//移库和其他入库
		if (String.valueOf(1).equals(dto.getPushType()) || String.valueOf(3).equals(dto.getPushType())) {
			getorder.setYrstore(new JAXBElement<>(new QName("yrstore"),String.class, dto.getWarehouseCode()));
		}

		//移库
		if (String.valueOf(1).equals(dto.getPushType())) {
			getorder.setYcstoreno(new JAXBElement<>(new QName("ycstoreno"),String.class, dto.getPushWarehouseCode()));
		}
		//其他出库
		if (String.valueOf(2).equals(dto.getPushType())) {
			getorder.setYcstore(new JAXBElement<>(new QName("ycstore"),String.class, dto.getWarehouseCode()));
		}
		getorder.setBilltype(new JAXBElement<>(new QName("billtype"),String.class, "N"));
		getorder.setCustno(new JAXBElement<>(new QName("custno"),String.class, dto.getStoreCode()));
		getorder.setStoreno(new JAXBElement<>(new QName("storeno"),String.class, "01"));

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
		 * blargess	赠品	字符				是	　Y-是/N否
		 * batchno	批号	字符				是
		 * barcode	主条码	字符				是
		 * Custno	货主	字符	8			否
		 */
        List<MoveStockDetailWmsDTO> detail = dto.getDetail();
        List<Getorderdet> getorderdets = new ArrayList<>();
        int index = 1;
        for(MoveStockDetailWmsDTO e: detail) {
	        Getorderdet getorderdet = new Getorderdet();
	        getorderdet.setCustprd(new JAXBElement<>(new QName("custprd"),String.class, e.getPushCode()));
	        getorderdet.setCrowno(index);
	        getorderdet.setIncode(new JAXBElement<>(new QName("incode"),String.class, e.getProductCode()));
	        getorderdet.setFname(new JAXBElement<>(new QName("fname"),String.class, e.getProductName()));
	        getorderdet.setUnit(new JAXBElement<>(new QName("unit"),String.class, e.getUnits()));
	        getorderdet.setPacks(Double.valueOf(String.valueOf(e.getQty())));
	        getorderdet.setQty(Double.valueOf(String.valueOf(e.getQty())));
	        getorderdet.setCustno(new JAXBElement<>(new QName("custno"),String.class, e.getStoreCode()));
	        getorderdets.add(getorderdet);
	        index += 1;
        }

		MoveStockWmsInfoDTO moveStockWmsInfoDTO = new MoveStockWmsInfoDTO();
		moveStockWmsInfoDTO.setGetorder(list);
        moveStockWmsInfoDTO.setGetorderdets(getorderdets);

        return moveStockWmsInfoDTO;
	}
}
