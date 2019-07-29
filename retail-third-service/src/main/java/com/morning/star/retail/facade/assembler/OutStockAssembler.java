package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.dto.OutStockWmsInfoDTO;
import com.morning.star.retail.facade.dto.OutStockDetailWmsDTO;
import com.morning.star.retail.facade.dto.OutStockSubmitWmsDTO;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.wms.Putorder;
import com.wms.Putorderdet;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutStockAssembler {

	public OutStockWmsInfoDTO transform(OutStockWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * custprd	单据编号	字符	15	　	是	否	　
		 * clientno	客户编码	字符	11	　	　	否	　
		 * ordertype	订单类型	字符	8	　	　	否	　S-销售单/P-调拨单
		 * odrtyp	是否紧急	字符				否	0-普通/1-紧急
		 * purdate	制单日期	日期	10	　	　	否	　
		 * purtime	制单时间	日期				否
		 * bookdate	预送货日期	日期	8	　	　	是	　
		 * booktime	预送货时间	日期				是
		 * operater	操作人	字符				否
		 * linkman	联系人姓名	字符				是
		 * linkphone	联系电话	字符				是
		 * linkaddree	联系地址地址	字符				是
		 * remark	备注	字符	12	　	　	是	　
		 * ycstoreno	出库仓库	字符	4			否
		 * Custno	货主	字符				否
		 * storeno	物流中心编码	字符				否	格式建议01/02
		 */
		Putorder putorder = new Putorder();
		putorder.setCustprd(new JAXBElement<>(new QName("custprd"), String.class, dto.getOutStockCode()));
		putorder.setClientno(new JAXBElement<>(new QName("clientno"), String.class, dto.getUserId()));
		putorder.setOrdertype(new JAXBElement<>(new QName("ordertype"), String.class, dto.getPushType()));
		putorder.setOdrtyp(new JAXBElement<>(new QName("odrtyp"), String.class, "0"));
		putorder.setBookdate(new JAXBElement<>(new QName("purdate"), String.class, dto.getCreateTime().split(" ")[0]));
		putorder.setBooktime(new JAXBElement<>(new QName("purtime"), String.class, dto.getCreateTime()));
		putorder.setOperater(new JAXBElement<>(new QName("operater"), String.class, dto.getOperatorName()));
		putorder.setLinkman(new JAXBElement<>(new QName("linkman"), String.class, dto.getUsername()));
		putorder.setLinkphone(new JAXBElement<>(new QName("linkphone"), String.class, dto.getPhone()));
		putorder.setLinkaddree(new JAXBElement<>(new QName("linkaddree"), String.class, dto.getAddress()));
		putorder.setRemark(new JAXBElement<>(new QName("remark"), String.class, dto.getRemark()));
		putorder.setYcstoreno(new JAXBElement<>(new QName("ycstoreno"), String.class, dto.getWarehouseCode()));
		putorder.setCustno(new JAXBElement<>(new QName("custno"), String.class, dto.getStoreCode()));
		putorder.setStoreno(new JAXBElement<>(new QName("storeno"), String.class, "01"));


		List<Putorder> list = new ArrayList<>();
		list.add(putorder);

		// 出库详情
		/**
		 * 字段名	中文名称	类型	宽度	精度	主键	为空	缺省值
		 * custprd	单据编号	字符	15		是	否	　
		 * cgeneralbid	明细序号	整数	4		是	否	　
		 * incode	商品编码	字符	11			否	　
		 * jobno	批号	字符	15			是	　
		 * barcode	主条码	字符	20			是
		 * qty	数量	实数	14			否	　
		 * unit	单位	字符	10			是
		 * hprc	单价	实数	14			是	　
		 * Custno	货主	字符	8			否
		 */
		int index = 1;
		List<Putorderdet> putorderdets = new ArrayList<>();
		for(OutStockDetailWmsDTO detail: dto.getDetail()) {
			Putorderdet putorderdet = new Putorderdet();
			putorderdet.setCustprd(new JAXBElement<>(new QName("custprd"), String.class, dto.getOutStockCode()));
			putorderdet.setCgeneralbid(new JAXBElement<>(new QName("cgeneralbid"), String.class, String.valueOf(index)));
			putorderdet.setQty(Double.valueOf(String.valueOf(detail.getQty())));
			putorderdet.setCustno(new JAXBElement<>(new QName("custno"), String.class, detail.getStoreCode()));
			putorderdet.setIncode(new JAXBElement<>(new QName("incode"), String.class, detail.getProductCode()));
			putorderdets.add(putorderdet);
			index += 1;
		}

		OutStockWmsInfoDTO outStockWmsInfoDTO = new OutStockWmsInfoDTO();
		outStockWmsInfoDTO.setPutorders(list);
		outStockWmsInfoDTO.setPutorderdets(putorderdets);

		return outStockWmsInfoDTO;
	}

	public OutStockWmsDTO transform(OutStockSubmitWmsDTO dto) {
		OutStockWmsDTO outStockWmsDTO = new OutStockWmsDTO();
		BeanUtils.copy(dto, outStockWmsDTO);

		outStockWmsDTO.setDetail(dto.getDetail().stream().map(e -> {
			OutStockDetailWmsDTO detail = new OutStockDetailWmsDTO();
			BeanUtils.copy(e, detail);

			detail.setStoreCode(dto.getStoreCode());
			return detail;
		}).collect(Collectors.toList()));

		return outStockWmsDTO;
	}
}
