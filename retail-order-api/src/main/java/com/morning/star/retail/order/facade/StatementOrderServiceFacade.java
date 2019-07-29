package com.morning.star.retail.order.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.morning.star.retail.order.facade.dto.DealSaleOrderDTO;
import com.morning.star.retail.order.facade.dto.FinanceSearchDTO;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.facade.dto.SellerOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.SellerSummaryOrderVO;
import com.morning.star.retail.order.facade.dto.SellerSummaryVO;
import com.morning.star.retail.order.facade.dto.StatementDataDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderVO;
import com.morning.star.retail.order.facade.dto.StatementSettingDTO;
import com.morning.star.retail.order.facade.dto.StatementSummaryInfo;
import com.morning.star.retail.order.facade.dto.StatementSummaryOrderVO;
import com.morning.star.retail.order.facade.dto.StatementSummaryVO;
import com.morning.star.retail.order.facade.dto.StatementWaterDTO;
import com.morning.star.retail.utils.page.PageBean;


public interface StatementOrderServiceFacade {
	
	/**
	 * 生成对账单
	 * @param statementOrder
	 */
	void saveOrder(StatementOrderDTO statementOrder);
	 
	/**
	 * 提交结算
	 * @param statementWaterDTO
	 */
	void submitOrder(StatementWaterDTO statementWaterDTO);
	
	 PageBean<StatementOrderDTO> queryStatementOrder(StatementOrderSearchDTO search);
	 
	 /**
	  * 查询已支付订单
	 * @param beginTime
	 * @param endTime
	 * @param
	 * @return
	 */
	 PageBean<DealSaleOrderDTO> queryDealSaleOrder(String companyCode,Date beginTime,Date endTime,Integer pageNo,Integer pageSize);
	 
	 /**
	  * 查询退款订单
	 * @param beginTime
	 * @param endTime
	 * @param accountPeroid
	 * @return
	 */
	 PageBean<RefundDTO> queryRefundOrder(String companyCode,Date beginTime,Date endTime,Integer accountPeroid,Integer pageNo,Integer pageSize);
	
	 /**
	  *查询结算流水
	 * @param statementCode
	 * @return
	 */
	 List<StatementWaterDTO> queryStatementWater(String statementCode);
	 
	 StatementDataDTO getStatementData(String companyCode,Date beginTime, Date endTime, Integer accountPeroid);
	 
	 /**
	  * 生成账期
	 * @param companyCode
	 * @return
	 * @throws ParseException
	 */
	boolean generateStatementOrder(String companyCode) throws ParseException;
	
	/**
	 * 查询账期订单明细
	 * @param companyCode
	 * @param statementCode
	 * @return
	 */
	StatementOrderDTO queryStatementDetail(String companyCode, String statementCode);
	
	/**
	 * 新增或更新设置
	 * @param statementSettingDTO
	 * @return
	 */
	int saveOrUpdateSetting(StatementSettingDTO statementSettingDTO);
	
	/**
	 * 获取账期设置
	 * @return
	 */
	StatementSettingDTO getStatementSetting();
	
	 /**
	 * 查询对账明细
	 * @param search
	 * @return
	 */
	PageBean<StatementOrderVO> queryDetail(StatementOrderSearchDTO search);
	
	 /**
	 * 查询运费
	 * @param search
	 * @return
	 */
	PageBean<StatementOrderVO> queryDeliveryFee(StatementOrderSearchDTO search);


	/**
	 * 汇总订单
	 * @param search
	 * @return
	 */
	PageBean<StatementSummaryOrderVO> orderList(FinanceSearchDTO search);

	/**
	 * 根据门店汇总
	 * @param search
	 * @return
	 */
	PageBean<StatementSummaryVO> storeSummary(FinanceSearchDTO search);

	/**
	 * 根据支付渠道汇总
	 * @param search
	 * @return
	 */
	StatementSummaryInfo tradeChannelSummary(FinanceSearchDTO search);

	/**
	 * 促销员结算汇总
	 * @param searchDTO
	 * @return
	 */
	PageBean<SellerSummaryVO> sellerSummary(SellerOrderSearchDTO searchDTO);

	/**
	 * 促销员订单明细
	 * @param searchDTO
	 * @return
	 */
	PageBean<SellerSummaryOrderVO> sellerOrderList(SellerOrderSearchDTO searchDTO);

	/**
	 *汇总订单商品销售额
	 * @param search
	 * @return
	 */
	PageBean<StatementOrderVO> orderItemSummary(StatementOrderSearchDTO search);
}
