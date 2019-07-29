package com.morning.star.retail.facade.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.morning.star.retail.entity.UpcCodeEntity;
import com.morning.star.retail.entity.repository.UpcCodeRepository;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.GoodsApplication;
import com.morning.star.retail.dao.GoodsDAO;
import com.morning.star.retail.facade.GoodsPosFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.facade.dto.GoodsPosSyncQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class GoodsPosFacadeImpl implements GoodsPosFacade {

	@Autowired
	private GoodsDAO goodsDAO;
	@Autowired
	private GoodsApplication goodsApplication;

	@Autowired
	private UpcCodeRepository upcCodeRepository;

	@Override
    public PageBean<GoodsDTO> queryGoods(GoodsPosSyncQueryDTO dto) {
	    RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<GoodsDTO> result = goodsDAO.queryPosSyncGoods(dto, rowBounds);
        return new PageBeanAssembler().toBean(result);
    }

	@Override
	public List<GoodsDTO> queryGoodsByUpc(GoodsPosSyncQueryDTO dto) {
		Validate.notEmpty(dto.getUpcCodes(), "不存在UPC信息");
		List<UpcCodeEntity> upcCodeEntityList = upcCodeRepository.getByUpcCodeIn(dto.getUpcCodes());
		List<String> sapCodes = upcCodeEntityList.stream()
			.map(UpcCodeEntity::getSapProductCode)
			.collect(Collectors.toList());

		return goodsDAO.queryPosGoodsByUpc(dto.getStoreCode(), sapCodes);
	}

	@Override
    public void makePrice(String goodsCode, BigDecimal price) {
        goodsApplication.makePrice(goodsCode, price);
    }

}
