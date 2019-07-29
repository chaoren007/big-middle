package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import com.wms.Partner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class CustomerAssembler {

	public List<Partner> transform(SupplierWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * partner_no	客户编码	字符		　	是	否	　
		 * partner_name	客户名称	字符		　	　	否	　
		 * partner_type	类型	字符		　	　	否	　
		 * partner_address	配送地址	字符		　	　	是	　
		 * partner_psid	配送客户路线	字符				是
		 * partner_order	路线顺序	字符		　	　	是	　
		 * partner_lxr	联系人	字符		　	　	是	　
		 * partner_tel	联系人电话	字符		　	　	是	　
		 * custno	货主	字符				是	暂时改为可空
		 */
		Partner partner = new Partner();
		partner.setPartnerNo(new JAXBElement<>(new QName("partner_no"),String.class, dto.getSupplierCode()));
		partner.setPartnerName(new JAXBElement<>(new QName("partner_name"),String.class, dto.getSupplierName()));
		partner.setPartnerType(new JAXBElement<>(new QName("partner_type"),String.class, "C"));
		partner.setCustno(new JAXBElement<>(new QName("custno"),String.class, dto.getStoreCode()));
		partner.setPartnerLxr(new JAXBElement<>(new QName("partner_lxr"),String.class, dto.getLinkman()));
		partner.setPartnerTel(new JAXBElement<>(new QName("partner_tel"),String.class, dto.getPhone()));
		partner.setPartnerAddress(new JAXBElement<>(new QName("partner_address"),String.class, dto.getAddress()));
		ArrayList<Partner> list = new ArrayList<>();
		list.add(partner);
		return list;
	}
}
