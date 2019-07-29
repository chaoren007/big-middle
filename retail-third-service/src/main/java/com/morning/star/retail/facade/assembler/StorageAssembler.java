package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.facade.dto.StorageWmsDTO;
import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import com.wms.Partner;
import com.wms.Store;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class StorageAssembler {

	public List<Store> transform(StorageWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * storeno	仓库编码	字符		　	是	否	　
		 * storename	仓库名称	字符		　	　	否	　
		 * custno	货主	字符				否
		 * cityid	城市编码	字符				是
		 * cityname	城市名称	字符				是
		 */
		Store store = new Store();
		store.setStoreno(new JAXBElement<>(new QName("storeno"),String.class, dto.getWarehouseCode()));
		store.setStorename(new JAXBElement<>(new QName("storename"),String.class, dto.getWarehouseName()));

		store.setCustno(new JAXBElement<>(new QName("custno"),String.class, dto.getStoreCode()));
		store.setCityid(new JAXBElement<>(new QName("cityid"),String.class, String.valueOf(dto.getCityId())));
		store.setCityname(new JAXBElement<>(new QName("cityname"),String.class, dto.getCityName()));

		ArrayList<Store> list = new ArrayList<>();
		list.add(store);
		return list;
	}
}
