package com.morning.star.retail.admin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSON;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.token.TokenManager;


@Activate(group = {Constants.CONSUMER}, order = -9000)
public class DubboContextFilter implements Filter {
	private static final String USER_INFO_KEY = "user_info_key";

	private Logger logger = LoggerFactory.getLogger(DubboContextFilter.class);

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		try {
			LoginUser user = TokenManager.getLoginUser();
			UserInfo info = new UserInfo();
			info.setId(user.getId());
			info.setName(user.getName());
			info.setTag("groupCode", user.getGroupCode());
			info.setTag("storeCode", user.getStoreCode());
			info.setTag("accountLevel", user.getAccountLevel());
			logger.info("DubboFilter Set UserInfo:" + JSON.toJSONString(user));

			logger.info(JSON.toJSONString(info));
			RpcContext.getContext().setAttachment(USER_INFO_KEY, JSON.toJSONString(info));
		} catch (Exception e) {
			logger.error("error in DubboContextFilter.setLogContext", e);
		}

		return invoker.invoke(invocation);
	}


}
