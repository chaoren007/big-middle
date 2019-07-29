package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.dto.GoodsWmsInfoDTO;
import com.morning.star.retail.facade.dto.GoodsWmsDTO;
import com.morning.star.retail.validate.Validate;
import com.wms.Goods;
import org.springframework.stereotype.Component;

import javax.persistence.Comment;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GoodsAssembler {

	public GoodsWmsInfoDTO transform(GoodsWmsDTO dto) {

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * incode	商品编码	字符		　	是	否	　
		 * fname	商品名称	字符		　	　	否	　
		 * pname	通用名	字符		　	　	否	　
		 * specs	规格	字符		　	　	否	　
		 * unit	单位	字符		　	　	否	　
		 * minpackqty	最小配送包装	数值			　	是	　1
		 * brand	品牌	字符		　	　	是	　
		 * origin	产地	字符		　	　	是	　
		 * bzq	保质期天数	字符		　	　	是	　
		 * PROPORTION	允许收货天数(保质期超此天数提示)	字符		　	　	是	　
		 * goods_flag	存储类型	字符				否
		 * checkflag	保质期标志	字符				否	Y/N
		 * type	分类编码	字符				否
		 * custno	货主	字符				否
		 * storeno	仓库	字符				否
		 * barcode	条码	字符				是
		 * isfresh	生鲜/常温	字符				否	1-生鲜/2-常温
		 * mulpackage	是否需要包装	字符				否	Y-是/N-否
		 * isweigh	是否称重	字符				否	Y-是/N-否
		 */
		Goods goods = new Goods();
		goods.setIncode(new JAXBElement<>(new QName("incode"),String.class, dto.getGoodsCode()));
		goods.setFname(new JAXBElement<>(new QName("fname"),String.class, dto.getGoodsName()));
		goods.setPname(new JAXBElement<>(new QName("pname"),String.class, dto.getGoodsName()));
		goods.setUnit(new JAXBElement<>(new QName("unit"),String.class, dto.getUnitsName()));
		goods.setType(new JAXBElement<>(new QName("type"),String.class, String.valueOf(dto.getCategoryId3())));
		goods.setBrand(new JAXBElement<>(new QName("brand"),String.class, dto.getBrandName()));
		goods.setBarcode(new JAXBElement<>(new QName("barcode"),String.class, dto.getUpcCode()));
		goods.setCustno(new JAXBElement<>(new QName("custno"),String.class, dto.getStoreCode()));
		goods.setMulpackage(new JAXBElement<>(new QName("mulpackage"),String.class, "N"));
		if (dto.getCommodityType() == 1) {
			goods.setIsweigh(new JAXBElement<>(new QName("isweigh"),String.class, "Y"));
		} else {
			goods.setIsweigh(new JAXBElement<>(new QName("isweigh"),String.class, "N"));
		}
		if (dto.getStorageType() == 1) {
			goods.setIsfresh(new JAXBElement<>(new QName("isfresh"),String.class, "2"));
		} else {
			goods.setIsfresh(new JAXBElement<>(new QName("isfresh"),String.class, "1"));
		}
		goods.setMinpackqty(Double.valueOf("1"));
		if (dto.getSpuInfo() != null) {
			goods.setSpecs(new JAXBElement<>(new QName("specs"),String.class, dto.getSpuInfo()));
		} else {
			goods.setSpecs(new JAXBElement<>(new QName("specs"),String.class, "1"));
		}
		if (dto.getShelfLife() != null) {
			goods.setBzq(new JAXBElement<>(new QName("bzq"),String.class, String.valueOf(dto.getShelfLife())));
			goods.setCheckflag(new JAXBElement<>(new QName("checkflag"),String.class, "Y"));
		} else {
			goods.setCheckflag(new JAXBElement<>(new QName("checkflag"),String.class, "N"));
		}

		ArrayList<Goods> list = new ArrayList<>();
		list.add(goods);

		/**
		 * 字段名	中文描述	类型	宽度	精度	主键	为空	缺省值
		 * barcode	条码	字符		　	是	否	　
		 * incode	商品编码	字符		　	　	否	　
		 * custno	货主	字符				否
		 * storeno	仓库	字符				是
		 */
		String[] codes = dto.getUpcCode().split(",");
		ArrayList<Goods> codeList = new ArrayList<>();

		Arrays.stream(codes).forEach(e -> {
			Goods codeInfo = new Goods();
			codeInfo.setBarcode(new JAXBElement<>(new QName("barcode"),String.class, e));
			codeInfo.setIncode(new JAXBElement<>(new QName("incode"),String.class, dto.getGoodsCode()));
			codeInfo.setCustno(new JAXBElement<>(new QName("custno"),String.class, dto.getStoreCode()));
			codeList.add(codeInfo);
		});

		GoodsWmsInfoDTO goodsWmsInfoDTO = new GoodsWmsInfoDTO();
		goodsWmsInfoDTO.setGoods(list);
		goodsWmsInfoDTO.setCodes(codeList);

		return goodsWmsInfoDTO;
	}
}
