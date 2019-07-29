package com.wms.bean;

import com.wms.Msg;
import com.wms.Remsg;

import java.util.List;

/**
 * @Author: kimhuhg
 * @Date: 18-11-22 上午10:23
 * @desc: 对wms返回参数作统一处理
 */
public class ResultFormat {
    public ResultBean getresult(Remsg result) {
        List<Msg> dataList = result.getDataList();
        if (dataList == null || dataList.size() < 0) {
            return new ResultBean("返回格式错误，请检查接口必传参数是否为null，若不为null，请联系接口对接人", 0, null);
        } else {
            Msg msg = dataList.get(0);
            return new ResultBean(msg.getMsg().getValue(), Integer.valueOf(msg.getStatus().getValue()), msg.getResult().getValue());
        }
    }
}
