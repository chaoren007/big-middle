package com.morning.star.log;

import org.slf4j.MDC;

public class MDCContext {

	private String requestId;
	private String className;
	private String methodName;
	private Long time;

	// 监控用
	private String traceId;
	private String spanId;
	private String parentSpanId;
	private String spanType = "DUBBO-SERVICE";
	private String serviceName;
	private Long receivedTime;
	private Long sendTime;
	private Long durationTime;
	private String otherInfo;

	protected void applyAll() {
		MDC.put("class", className);
		MDC.put("method", methodName);
		if (time != null) {
			MDC.put("time", String.valueOf(time));
		} else {
			MDC.put("time", "0");
		}
		MDC.put("requestId", requestId);


		MDC.put("traceId", traceId);
		MDC.put("spanId", spanId);
		MDC.put("parentSpanId", parentSpanId);
		MDC.put("spanType", spanType);
		MDC.put("serviceName", serviceName);
		MDC.put("receivedTime", receivedTime != null ? String.valueOf(receivedTime) : "0");
		MDC.put("sendTime", sendTime != null ? String.valueOf(sendTime) : "0");
		MDC.put("durationTime", durationTime != null ? String.valueOf(durationTime) : "0");
		MDC.put("otherInfo", otherInfo);
	}

	protected void applyTime(Long time) {
		this.time = time;
		MDC.put("time", String.valueOf(time));
	}

	protected void applyReceivedTime(Long time) {
		this.receivedTime = time != null ? time : System.currentTimeMillis();
		MDC.put("receivedTime", String.valueOf(this.receivedTime));
	}

	protected void applySendTime(Long time) {
		this.sendTime = time != null ? time : System.currentTimeMillis();
		MDC.put("sendTime", String.valueOf(this.sendTime));
		if (this.receivedTime != null) {
			this.durationTime = this.sendTime - this.receivedTime;
			MDC.put("durationTime", String.valueOf(this.durationTime));
		}
	}

	protected void applyOtherInfo() {
		MDC.put("otherInfo", otherInfo);
	}

	protected static void clear() {
		MDC.remove("class");
		MDC.remove("method");
		MDC.remove("time");
		MDC.remove("requestId");

		MDC.remove("traceId");
		MDC.remove("spanId");
		MDC.remove("parentSpanId");
		MDC.remove("spanType");
		MDC.remove("serviceName");
		MDC.remove("receivedTime");
		MDC.remove("sendTime");
		MDC.remove("durationTime");
		MDC.remove("otherInfo");
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getSpanId() {
		return spanId;
	}

	public void setSpanId(String spanId) {
		this.spanId = spanId;
	}

	public String getParentSpanId() {
		return parentSpanId;
	}

	public void setParentSpanId(String parentSpanId) {
		this.parentSpanId = parentSpanId;
	}

	public String getSpanType() {
		return spanType;
	}

	public void setSpanType(String spanType) {
		this.spanType = spanType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Long getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(Long receivedTime) {
		this.receivedTime = receivedTime;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public Long getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(Long durationTime) {
		this.durationTime = durationTime;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
