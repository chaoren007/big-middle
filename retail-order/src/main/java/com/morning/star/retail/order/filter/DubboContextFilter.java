package com.morning.star.retail.order.filter;

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


@Activate(group = {Constants.PROVIDER}, order = -9000)
public class DubboContextFilter implements Filter {
	private static final String USER_INFO_KEY = "user_info_key";

	private Logger logger = LoggerFactory.getLogger(DubboContextFilter.class);

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String s = RpcContext.getContext().getAttachment(USER_INFO_KEY);
		System.out.print(s);

		return invoker.invoke(invocation);
	}


}
