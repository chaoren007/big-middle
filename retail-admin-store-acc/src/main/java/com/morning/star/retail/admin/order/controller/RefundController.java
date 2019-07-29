package com.morning.star.retail.admin.order.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.order.vo.RefundVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.PoiUtil;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.order.enums.PayChannel;
import com.morning.star.retail.order.enums.RefundPayStatus;
import com.morning.star.retail.order.facade.RefundServiceFacade;
import com.morning.star.retail.order.facade.dto.ConfirmRefundDTO;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.facade.dto.RefundSearchDTO;
import com.morning.star.retail.util.DateUtil;
import com.morning.star.retail.utils.page.PageBean;

@Controller
@RequestMapping(value = "/api")
public class RefundController extends AdminController {
	/**
	 * 导出Excel标题
	 */
	private static final String TITLE = "退款单";
	/**
	 * 导出Excel文件全名
	 */
	private static final String FILE_NAME = "退款单.xlsx";
	/**
	 * 导出Excel表头
	 */
	private static final String[] HEADERS = { "退款单编号", "门店名称", "支付方式", "退款金额", "退款类型", "预付卡退款金额", "关联订单号",
			"售后订单号","操作人名字","退款状态","退款单生成时间","退款时间" };
	
    @Autowired
    private RefundServiceFacade refundServiceFacade;
    
    @RequestMapping(value = "/profiles/pay-channel-list")
    @ResponseBody
	
    public WebJsonBean payList() throws Exception {
        return success(PayChannel.toList());
    }
    
    /**
     * 获取退款列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/refunds", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<PageBean<RefundDTO>> listRefunds(@RequestBody RefundSearchDTO search) {
    	String storeCode = getLoginAdmin().getStoreCode();
    	search.setStoreCode(storeCode);
    	search.setStatuses(getStatuses(search.getStatus()));
        search.setStatus(null);

        List list = new ArrayList();
        PageBean<RefundDTO> dataPage = new PageBean<>(1, list, search.getPageNo(), search.getPageSize(), 1);
                //refundServiceFacade.queryRefund(search);
        return WebBean.ok(dataPage);
    }




    /**
     * 确认退款
     * @param refundCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/refunds/{refundCode}/refund", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> confirmRefund(@PathVariable String refundCode, @RequestBody ConfirmRefundDTO form) throws Exception {
        if(StringUtils.isNoneBlank(form.getRefundInfo()) && form.getRefundInfo().length() > 120) {
            throw new IllegalArgumentException("退款备注不能超过120个字符");
        }
        RefundPayStatus payStatus = refundServiceFacade.refund(refundCode, form);
        // 前端只处理待退款, 退款中, 退款失败, 退款成功,  这里要转化
        payStatus = convertStatus(payStatus.getCode());
        return WebBean.ok();
    }

    @RequestMapping(value = "/refunds/detail")
    @ResponseBody
    public WebBean<RefundDTO> detail(String code) {
        return WebBean.ok(refundServiceFacade.getRefund(code));
    }

    private RefundPayStatus convertStatus(Integer code) {
        if(code == null) {
            return RefundPayStatus.WAIT_REFUND;
        }

        if(RefundPayStatus.isSuccess(code)) {
            return RefundPayStatus.REFUND_SUCCESS;
        }

        if(RefundPayStatus.isFail(code)) {
            return RefundPayStatus.REFUND_FAIL;
        }

        return RefundPayStatus.getStatus(code);
    }


    private List<Integer> getStatuses(Integer status) {
        if(status == null) {
            return null;
        }

        List<Integer> statuses = new ArrayList<>();
        statuses.add(status);

        if(status == RefundPayStatus.REFUND_SUCCESS.getCode()) {
            statuses.add(RefundPayStatus.OFFLINE_REFUND.getCode());
        } else if(status == RefundPayStatus.REFUND_FAIL.getCode()) {
            statuses.add(RefundPayStatus.ASK_FAIL.getCode());
            statuses.add(RefundPayStatus.UNSUPPORTED.getCode());
        }

        return statuses;
    }

    @RequestMapping(value = "/refunds/exportRefund")
    public void exportRefund(HttpServletResponse response,RefundSearchDTO search){
        search.setStoreCode(getLoginAdmin().getStoreCode());
        search.setStatus(null);
        search.setStartTime(search.getStartTime());
        search.setEndTime(search.getEndTime());
		search.setPageNo(1);
		search.setPageSize(Integer.MAX_VALUE);
		
        PageBean<RefundDTO> dataPage = refundServiceFacade.queryRefund(search);
        
        List<RefundVO> orderList = dataPage.getRecord().stream().map(e -> {
            RefundVO vo = RefundVO.fromDTO(e);

            // 前端只处理待退款, 退款中, 退款失败, 退款成功,  这里要转化
            RefundPayStatus status = convertStatus(vo.getStatus());
            if(status != null) {
                vo.setStatus(status.getCode());
                vo.setStatusDesc(status.getDesc());
            }

            vo.setAmount(e.getAmount());
            //vo.setAmount(getTotalAmount(e));
            return vo;
        }).collect(Collectors.toList());
        
    	List<List<Object>> list = this.getExportData(orderList);
		if (CollectionUtils.isEmpty(list)) {
		    list = Collections.emptyList();
		}
	
	
		try {
			PoiUtil.exportExcel(TITLE, HEADERS, list, FILE_NAME, response);
		} catch (Exception e) {
			throw new IllegalArgumentException("导出账期数据错误");
		}
    }

    public List<List<Object>> getExportData(List<RefundVO> orderList) {
		List<List<Object>> list = new ArrayList<List<Object>>();
		
		for (RefundVO order : orderList) {
			List<Object> rowList = new ArrayList<>();
			
			rowList.add(order.getCode());
			rowList.add(order.getStore()== null?"":order.getStore().getName());
			rowList.add(order.getPayChannelDesc());
			rowList.add(order.getAmount());
			rowList.add("0".equals(order.getType())?"取消退款":"售后退款");
			rowList.add(order.getPrepayCardAmount());
			rowList.add(order.getOrderCode());
			rowList.add(order.getAfterSalesCode());
			rowList.add(order.getOperatorName());
			rowList.add(order.getStatusDesc());
			rowList.add(order.getCreateTime()==null?"":DateUtil.toString(order.getCreateTime()));
			rowList.add(order.getRefundTime()==null?"":DateUtil.toString(order.getRefundTime()));
		
			list.add(rowList);
		}
		return list;
	}

}
