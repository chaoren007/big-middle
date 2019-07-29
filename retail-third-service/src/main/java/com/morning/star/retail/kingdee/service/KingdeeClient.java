package com.morning.star.retail.kingdee.service;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.morning.star.retail.dto.KingdeeResultDTO;
import com.morning.star.retail.dto.KingdeeSubmitDTO;
import com.morning.star.retail.dto.LoginDTO;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.enums.RequestTypeEnum;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KingdeeClient {
    @Autowired
    private InvokeHelper invokeHelper;

    @Autowired
    private ThirdServiceRepository thirdServiceRepository;

    private static final Logger log = LoggerFactory.getLogger(KingdeeClient.class);

    /**
     * 同步信息到金蝶云
     * @param formid 表单类型 由Kingde文档提供
     * @param context 请求参数
     * @param requestApi 请求的标识
     * @param requestTag  请求枚举
     */
    public void add(String formid,String context,String requestApi,RequestTagEnum requestTag){
        ThirdServiceEntity entity = new ThirdServiceEntity(requestApi, context, requestTag, RequestTypeEnum.KINGDEE_CLOUD);
        ThirdServiceEntity saveEntity = thirdServiceRepository.save(entity);
        try {
            final LoginDTO login = invokeHelper.login();
            if (login != null && login.getLoginResultType().intValue() == 1) {
                //登陆成功
                //1、保存
                String saveResult = invokeHelper.save(formid, context);
                //过滤不需要的字段
                Gson gson = new Gson();
                KingdeeResultDTO saveResultDto = gson.fromJson(saveResult, KingdeeResultDTO.class);
                //setResponse
                saveEntity.setResponse(gson.toJson(saveResultDto));
                if (saveResultDto.getResult().getResponseStatus().isIsSuccess()) {
                    String number = JSON.toJSONString(new KingdeeSubmitDTO(saveResultDto.getResult().getNumber()));
                    //2、提交
                    KingdeeResultDTO submitResultDto = gson.fromJson(invokeHelper.submit(formid, number), KingdeeResultDTO.class);
                    if (submitResultDto.getResult().getResponseStatus().isIsSuccess()) {
                        //3、审核
                        KingdeeResultDTO auditResultDto = gson.fromJson(invokeHelper.audit(formid, number), KingdeeResultDTO.class);
                        if (auditResultDto.getResult().getResponseStatus().isIsSuccess()) {
                            saveEntity.setRequestStatus(RequestStatusEnum.AUDIT);
                        } else {
                            saveEntity.setRequestStatus(RequestStatusEnum.SUBMIT);
                        }
                    } else {
                        saveEntity.setRequestStatus(RequestStatusEnum.SUCCESS);
                    }
                } else {
                    saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
                }
            } else {
                saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
                log.info("==========================登陆kingdee失败==========================");
            }
        } catch (Exception e) {
            saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
        } finally {
            log.info("========保存数据库======");
            thirdServiceRepository.save(saveEntity);
        }
    }

    public void delete(String formid,String context,String requestApi,RequestTagEnum requestTag){
                ThirdServiceEntity saveEntity = thirdServiceRepository.getByRequestParamAndRequestApi(context,requestApi);
        if (saveEntity == null || saveEntity.getResponse() == null || saveEntity.getResponse().isEmpty()) {
            return;
        }
        //这里只能用Gson
        Gson gson = new Gson();
        KingdeeResultDTO response = gson.fromJson(saveEntity.getResponse(), KingdeeResultDTO.class);
        //把numbers编码作为参数
        String number = JSON.toJSONString(new KingdeeSubmitDTO(response.getResult().getNumber()));
//        ThirdServiceEntity entity = new ThirdServiceEntity(requestApi, number, requestTag, RequestTypeEnum.KINGDEE_CLOUD);
//        ThirdServiceEntity saveEntity = thirdServiceRepository.save(entity);
//        saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
        try {
            LoginDTO login = invokeHelper.login();
            if (login != null && login.getLoginResultType().intValue() == 1) {
                //登陆成功
                //1、反审核
                KingdeeResultDTO unAuditResultDto = gson.fromJson(invokeHelper.unAudit(formid, number), KingdeeResultDTO.class);
                if (unAuditResultDto.getResult().getResponseStatus().isIsSuccess()) {
                    saveEntity.setRequestStatus(RequestStatusEnum.UNAUDIT);
                    //2、删除
                    KingdeeResultDTO deleteResult = gson.fromJson(invokeHelper.delete(formid, number), KingdeeResultDTO.class);
                    if (deleteResult.getResult().getResponseStatus().isIsSuccess()) {
                        saveEntity.setRequestStatus(RequestStatusEnum.DELETE);
                        saveEntity.setResponse(gson.toJson(deleteResult));
                    }
                }
            } else {
                log.info("==========================登陆kingdee失败==========================");
            }
        } catch (Exception e) {
            saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
        } finally {
            log.info("========保存数据库======" + JSON.toJSONString(saveEntity));
            thirdServiceRepository.save(saveEntity);
        }
    }
}
