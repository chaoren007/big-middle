package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.facade.dto.StoreWmsDTO;
import com.morning.star.retail.validate.Validate;
import com.wms.Customer;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class StoreAssembler {

	@Validate
	public List<Customer> transform(StoreWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * custno	公司编码	字符		　	是	否	　
		 * custname	公司名称	字符		　	　	否	　
		 */
		Customer customer = new Customer();
		customer.setCustno(new JAXBElement<>(new QName("custno"), String.class, dto.getStoreCode()));
		customer.setCustname(new JAXBElement<>(new QName("custname"), String.class, dto.getStoreName()));
		ArrayList<Customer> list = new ArrayList<>();
		list.add(customer);
		return list;
	}
}
