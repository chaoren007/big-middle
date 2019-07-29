package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.replenish.*;
import com.morning.star.retail.stock.dto.ExportReplenishDTO;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface ReplenishFacade {

    /**
     * 提交补货单
     *
     * @param submitDTO
     * @return
     */
    String submit(ReplenishSubmitDTO submitDTO);

    /**
     * 补货列表
     *
     * @param queryDTO
     * @return
     */
    PageBean<ReplenishDTO> list(ReplenishQueryDTO queryDTO);

    /**
     * 补货详情
     *
     * @param queryDTO
     * @return
     */
    ReplenishDTO get(ReplenishQueryDTO queryDTO);

    PageBean<ReplenishItemSimpleDTO> replenishDetail(ReplenishItemQueryDTO dto);

    /**
     * 修改补货列表
     *
     * @param replenishDTO
     * @return
     */
    Integer modify(ReplenishUpdateDTO replenishDTO);

    /**
     * 确认
     */
    Integer confirm(List<ReplenishAuditDTO> replenishAuditDTOS);

    /**
     * 驳回
     */
    Integer reject(List<ReplenishAuditDTO> replenishAuditDTOS);

    /**
     * 拣货
     */
    Integer prepareReplenish(ReplenishAuditDTO replenishAuditDTO);

    /**
     * 配送
     */
    Integer deliveryReplenish(ReplenishAuditDTO replenishAuditDTO);

    List<ExportReplenishDTO> getExportData(ReplenishQueryDTO replenishQueryDTO);
}
