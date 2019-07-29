package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/11/15.
 */
public interface ReceiptFacade {
    /**
     * 保存入库单
     *
     * @param receiptAddDTO
     * @return
     */
    String saveReceipt(ReceiptAddDTO receiptAddDTO);


    /**
     * 入库列表
     *
     * @return
     */
    PageBean<ReceiptDTO> list(ReceiptQueryDTO queryDTO);

    /**
     * 入库单详情
     *
     * @param queryDTO
     * @return
     */
    ReceiptDTO get(ReceiptQueryDTO queryDTO);

    /**
     * 确认入库
     *
     * @return
     */
    void sureReceipt(SureReceiptDTO sureReceiptDTO, Map<String, List<ReceiptImeiDTO>> iemis);

    /**
     * 修改入库细表数据
     *
     * @param receiptItemInfoDTO
     * @return
     */
    void modifyReceiptDetail(ReceiptItemDTO receiptItemInfoDTO);

    /**
     * 根据入库单查询需要提醒过期的商品
     *
     * @return
     */
    PageBean<ExpiredGoodsDTO> queryExpiredGoods(ExpiredGoodsQueryDTO queryDTO);

    /**
     * 获取入库细表列表
     *
     * @param receiptCode
     * @return
     */
    List<ReceiptItemDTO> queryDetail(String receiptCode);

    /**
     * 获取入库列表(用于出库)
     *
     * @return
     */
    PageBean<ReceiptDTO> list(QueryByRoleDTO search);

    /**
     * 第三方出库单号填写
     */
    void addOutStockCode(String receiptCode, String outstockCode);

    /**
     * 填写预计入库时间
     */
    void addExpectedReceiptTime(String receiptCode, Date expectedReceiptTime);

    /**
     * 修改入库状态
     */
    void modifyTransStatus(String receiptCode, Integer transStatus);

    /**
     * 批量导入产生入库单
     *
     * @param list
     * @return
     */
    void batchSaveReceipt(List<ReceiptAddDTO> list);

    /**
     * 采购入库
     *
     * @param dto
     * @return
     */
    boolean purchaseReceipt(ReceiptAddDTO dto);
}
