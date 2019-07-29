package com.morning.star.retail.facade;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.dto.WarehouseQueryDTO;

import java.util.List;

public interface WarehouseFacade {
    /**
     * 新增仓库 返回生成的仓库编码
     * @param dto
     * @return
     */
     String create(WarehouseDTO dto);

    /**
     * 分页查询
     * @param dto
     * @return
     */
     PageBeans<WarehouseDTO> queryPage(WarehouseQueryDTO dto);

    /**
     * 列表查询
     * @param dto
     * @return
     */
    List<WarehouseDTO> queryList (WarehouseQueryDTO dto);

    /**
     * 编辑 ID不能为空
     * @param dto
     * @return
     */
    void edit (WarehouseDTO dto);

    /**
     * 删除 ID不能为空
     * @param dto
     * @return
     */
    void delete (WarehouseQueryDTO dto);


    /**
     * 获取有仓库的城市列表
     * @param
     */
    List<WarehouseDTO> listcity(String groupCode);

    /**
     * 传入storeCode 和 groupCode  集团端city必填
     * @param dto
     */
    List<WarehouseDTO> listWarehouse(WarehouseQueryDTO dto);


    WarehouseDTO getByWarehouseCode(String warehouseCode);
}
