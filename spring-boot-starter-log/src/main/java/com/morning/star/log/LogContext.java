package com.morning.star.log;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LogContext {

	// userId上下文    暂时不使用
	private static ThreadLocal<String> userIdContext = new ThreadLocal<>();
	// requestId上下文
	private static ThreadLocal<String> requestIdContext = new ThreadLocal<>();

	// 发生异常时,要保留RequestId ,因为在调用链结束后, 全局异常处理器GlobalExceptionHandler还需要获取
	private static ThreadLocal<String> errRequestId = new ThreadLocal<>();

	// 调用链开始时的时间戳
	private static ThreadLocal<Long> stackStartTime = new ThreadLocal<>();


	private static ThreadLocal<String> traceIdContext = new ThreadLocal<>();
	private static ThreadLocal<String> parentSpanIdContext = new ThreadLocal<>();
	private static ThreadLocal<String> spanIdContext = new ThreadLocal<>();
	private static ThreadLocal<Map<String, String>> otherInfoContext = new ThreadLocal<>();

	public static void setRequestToErr() {
		errRequestId.set(requestIdContext.get());
	}


	/**
	 * 获取requestId, 如果当前requestId为空,则返回errRequestId
	 *
	 * @return
	 */
	public static String getRequestIdOrErr() {
		String requestId = requestIdContext.get();
		if (requestId != null) {
			return requestId;
		}

		return errRequestId.get();
	}

	/**
	 * 获取requestId
	 *
	 * @return
	 */
	public static String getRequestId() {
		String id = requestIdContext.get();
		if (id == null) {    // 如果当前为空, 会创建requestId以免出null异常
			id = UUID.randomUUID().toString().replace("-", "");
		}
		return id;
	}

	public static String getTraceId() {
		String id = traceIdContext.get();
		if (id == null) {    // 如果当前为空, 会创建requestId以免出null异常
			id = UUID.randomUUID().toString().replace("-", "");
		}
		return id;
	}

	public static Map<String, String> getOtherInfo() {
		return otherInfoContext.get();
	}

	public static String getParentSpanId() {
		String id = parentSpanIdContext.get();
		if (id == null) {    // 如果当前为空, 会创建requestId以免出null异常
			id = UUID.randomUUID().toString().replace("-", "");
		}
		return id;
	}

	public static String getSpanId() {
		String id = spanIdContext.get();
		if (id == null) {    // 如果当前为空, 会创建requestId以免出null异常
			id = UUID.randomUUID().toString().replace("-", "");
		}
		return id;
	}

	/**
	 * 获取顺序
	 *
	 * @return
	 */
	public static Long getMethodSequence() {
		Long startTime = stackStartTime.get();
		if (startTime == null) {
			return 0L;
		}
		// 用当前时间减调用链开始时间
		return System.currentTimeMillis() - startTime;
	}


	public static String getUserId() {
		return userIdContext.get();
	}

	public static void setUserId(String userId) {
		userIdContext.set(userId);
	}

	public static void setRequestId(String requestId) {
		requestIdContext.set(requestId);
	}

	public static void setTraceId(String traceId) {
		traceIdContext.set(traceId);
	}

	public static void setSpanId(String spanId) {
		spanIdContext.set(spanId);
	}

	public static void setParentSpanId(String parentSpanId) {
		parentSpanIdContext.set(parentSpanId);
	}

	public static void setOtherInfoMap(Map<String, String> map) {
		otherInfoContext.set(map);
	}

	public static void setOtherInfo(String key, String value) {
		Map map = otherInfoContext.get();
		if(map == null) {
			map = new HashMap<String, String>();
		}
		map.put(key, value);
		otherInfoContext.set(map);
	}

	/**
	 * 调用链开始时, 需要调用createRequestIfNecessary创建log的上下文
	 *
	 * @return
	 */
	public static void createRequestIfNecessary() {
		String id = requestIdContext.get();
		if (id == null) {    // 创建requestId
			id = UUID.randomUUID().toString().replace("-", "");
			requestIdContext.set(id);
		}

		String tid = traceIdContext.get();
		if (tid == null) {
			tid = UUID.randomUUID().toString().replace("-", "");
			traceIdContext.set(tid);
		}

		String sid = spanIdContext.get();
		if (sid == null) {
			sid = UUID.randomUUID().toString().replace("-", "");
			spanIdContext.set(sid);
		}

		String psid = parentSpanIdContext.get();
		if (psid == null) {
			psid = UUID.randomUUID().toString().replace("-", "");
			parentSpanIdContext.set(psid);
		}

		if (stackStartTime.get() == null) {
			stackStartTime.set(System.currentTimeMillis());
		}
	}

	/**
	 * 调用链结束后, 需要调用clearLogContext清理上下文
	 */
	protected static void clearLogContext() {
		requestIdContext.set(null);

		traceIdContext.set(null);
		parentSpanIdContext.set(null);
		spanIdContext.set(null);
		otherInfoContext.set(null);

		stackStartTime.set(null);
	}

}
