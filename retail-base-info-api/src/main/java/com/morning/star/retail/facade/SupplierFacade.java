package com.morning.star.retail.facade;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.dto.*;

import java.util.List;

public interface SupplierFacade {

    /******************   供应商   ******************/

    /**
     * 供应商申请-获取验证码
     *
     * @param mobile
     */
    void captcha(String mobile);

    /**
     * 供应商申请-校验验证码
     *
     * @param dto
     */
    SupplierApplyDTO checkCaptcha(CaptchaDTO dto);

    /**
     * 供应商申请-提交申请
     *
     * @param dto
     */
    void submit(SupplierSubmitDTO dto);

    /**
     * 供应商申请列表
     *
     * @param queryDTO
     * @return
     */
    PageBeans<SupplierApplyDTO> listApply(SupplierQueryDTO queryDTO);

    /**
     * 供应商申请详情
     *
     * @param id
     * @return
     */
    SupplierApplyDTO getApply(Long id);

    /**
     * 供应商申请-审核通过
     *
     * @param dto
     */
    void authPass(SupplierAuthPassDTO dto);

    /**
     * 供应商申请-审核失败
     *
     * @param dto
     */
    void authFail(SupplierAuthFailDTO dto);

    /**
     * 新增供应商
     *
     * @param dto
     */
    void create(SupplierCreateDTO dto);

    /**
     * 供应商-修改
     *
     * @param dto
     */
    void modify(SupplierDTO dto);

    /**
     * 供应商-修改状态
     *
     * @param dto
     */
    void modifyStatus(SupplierModifyDTO dto);

    /**
     * 供应商-删除
     *
     * @param supplierCode
     * @param groupCode
     */
    void delete(String supplierCode, String groupCode);

    /**
     * 供应商-列表
     *
     * @param queryDTO
     * @return
     */
    PageBeans<SupplierDTO> list(SupplierQueryDTO queryDTO);

    /**
     * 供应商-详情
     *
     * @param id
     * @return
     */
    SupplierDTO get(Long id);

    /**
     * 供应商-详情
     *
     * @param supplierCode
     * @return
     */
    SupplierDTO get(String supplierCode);

    List<SupplierDTO> queryByUpc(SupplierQueryDTO queryDTO);

    /**
     * 根据供应商编码和集团编码获取供应商信息 如果没有则返回空对象
     *
     * @param supplierCode
     * @param groupCode
     * @return
     */
    SupplierDTO get(String supplierCode, String groupCode);

    /******************   供应商-供货门店   ******************/

    void createStore(SupplierStoreDTO dto);

    void deleteStore(SupplierStoreDTO dto);

    PageBeans<SupplierStoreDTO> listStore(SupplierQueryDTO queryDTO);

    /******************   供应商-供应货品   ******************/

    void createItem(SupplierItemFormDTO formDTO);

    void modifyItem(SupplierItemFormDTO formDTO);

    void deleteItem(SupplierItemDeleteDTO dto);

    PageBeans<SupplierItemDTO> listItem(SupplierQueryDTO queryDTO);

    SupplierItemDTO getItem(SupplierQueryDTO queryDTO);

    List<SupplierItemDTO> queryItem(SupplierQueryDTO queryDTO);

    List<ExportSuppilerItemDTO> queryExportItem(String supplierCode);

}
