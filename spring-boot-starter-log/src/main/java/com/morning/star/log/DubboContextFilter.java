package com.morning.star.log;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.Map;

/**
 * 设置logger的上下文信息，如requestId，userId
 * Created by liangguobin on 2017/6/20.
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER},order = -9000)
public class DubboContextFilter implements Filter {
    private static final String REQUEST_ID_KEY = "requestId";
    private static final String USER_ID_KEY = "userId";

    private static final String TRACE_ID_KEY = "traceId";
    private static final String SPAN_ID_KEY = "spanId";
    private static final String OTHER_INFO_KEY = "otherInfo";

    private Logger logger = LoggerFactory.getLogger(DubboContextFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        try {
            // 如果从dubbo上下文中获取requestId为空，则创建requestId
            if (RpcContext.getContext().getAttachment(REQUEST_ID_KEY) == null) {
                String requestId = LogContext.getRequestId();
                RpcContext.getContext().setAttachment(REQUEST_ID_KEY, requestId);

                String traceId = LogContext.getTraceId();
                RpcContext.getContext().setAttachment(TRACE_ID_KEY, traceId);

                String  spanId = LogContext.getSpanId();
                RpcContext.getContext().setAttachment(SPAN_ID_KEY, spanId);

                Map<String, String> otherInfo = LogContext.getOtherInfo();
                if(otherInfo != null) {
                    RpcContext.getContext().setAttachment(OTHER_INFO_KEY, JSON.toJSONString(otherInfo));
                } else {
                    RpcContext.getContext().setAttachment(OTHER_INFO_KEY, "{}");
                }
            } else {
                // 设置requestId到logger上下文
                LogContext.setRequestId(RpcContext.getContext().getAttachment(REQUEST_ID_KEY));

                LogContext.setTraceId(RpcContext.getContext().getAttachment(TRACE_ID_KEY));

                LogContext.setParentSpanId(RpcContext.getContext().getAttachment(SPAN_ID_KEY));

                LogContext.setOtherInfoMap((Map) JSON.parse(RpcContext.getContext().getAttachment(OTHER_INFO_KEY)));
            }

            // 如果从dubbo上下文中获取userId为空而且LoggerUtils获取userId不为空，则设置userId
//            if (RpcContext.getContext().getAttachment(USER_ID_KEY) == null) {
//                if (LogContext.getUserId() != null) {
//                    RpcContext.getContext().setAttachment(USER_ID_KEY, LogContext.getUserId());
//                }
//            } else {
//                // 设置userId到logger上下文
//                LogContext.setUserId(RpcContext.getContext().getAttachment(USER_ID_KEY));
//            }

        } catch (Exception e) {    // 处理所有的异常，以免干扰主流程
            logger.error("error in DubboContextFilter.setLogContext", e);
        }

        return invoker.invoke(invocation);
    }


}
