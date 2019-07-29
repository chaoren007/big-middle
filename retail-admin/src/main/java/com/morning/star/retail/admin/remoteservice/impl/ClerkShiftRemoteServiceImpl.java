package com.morning.star.retail.admin.remoteservice.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.admin.bean.ClerkShiftDO;
import com.morning.star.retail.admin.bo.ClerkShiftBO;
import com.morning.star.retail.admin.remoteservice.ClerkShiftRemoteService;
import com.morning.star.retail.admin.service.ClerkShiftRecordService;
import com.morning.star.retail.admin.utils.page.PageBeanAssembler;
import com.morning.star.retail.admin.utils.page.RowBoundsBuilder;
import com.morning.star.retail.admin.vo.ClerkShiftVO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by lenovo on 2017/7/20.
 */
@Service("clerkShiftRemoteService")
public class ClerkShiftRemoteServiceImpl implements ClerkShiftRemoteService {

	@Autowired
	private ClerkShiftRecordService clerkShiftRecordService;

	@Override
	public int addShiftRecord(ClerkShiftDO clerkShiftDO) {
		return this.clerkShiftRecordService.addShiftRecord(clerkShiftDO);
	}

	@Override
	public PageBean<ClerkShiftVO> listShiftRecord(ClerkShiftBO clerkShiftBO) {
		RowBounds build = RowBoundsBuilder.build(clerkShiftBO.getPageNo(), clerkShiftBO.getPageSize());
		Page<ClerkShiftVO> page = clerkShiftRecordService.pageShiftRecord(clerkShiftBO, build);

		return new PageBeanAssembler().toBean(page);
	}
}
