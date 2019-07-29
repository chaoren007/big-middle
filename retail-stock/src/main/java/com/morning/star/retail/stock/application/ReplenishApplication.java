package com.morning.star.retail.stock.application;

import com.morning.star.retail.facade.dto.replenish.ReplenishAuditDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishSubmitDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishUpdateDTO;

import java.util.List;

public interface ReplenishApplication {
    /**
     * 提交补货单
     */
    String submitReplenish(ReplenishSubmitDTO replenishDTO);

    /**
     * 总部主动补货
     */
    void addReplenish(ReplenishSubmitDTO replenishDTO);

    /**
     * 修改补货列表
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

}
