package com.morning.star.openfalcon.profiler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.morning.star.openfalcon.agent.Metric;
import com.morning.star.openfalcon.agent.OpenFalconAgent;

public class TraceProfiler {
	
	@Value("${spring.application.name:}")
	private String service;
    
    private final TraceStack<EntryNode> stack = new TraceStack<>();
    private OpenFalconAgent agent;
    
    public TraceProfiler(OpenFalconAgent agent) {
		this.agent = agent;
	}

	public void start(String path, String method) {
        EntryNode entry = stack.isEmpty() 
        		? new EntryNode(service, path, method, method, 0) 
        		: new EntryNode(service, path, method, stack.first().method, stack.size());
        stack.push(entry);
        pushCounter(entry);
    }
    
    public void end() {
        EntryNode entry = stack.pop();
        entry.end();
        pushAvgDelayTime(entry);
		pushSuccRate(entry);
    }
    
    /** 保存异常信息 */
    public void error(Throwable e) {
        EntryNode entry = stack.last();
        entry.setErr(e);
        pushErrMetric(entry);
    }

    /**
     * 代表一个计时单元。
     */
    private static final class EntryNode {
        private final String service;
        private final String path;
        private final String method;
        private final String biz;
        private long startTime;
        private long endTime;
        private long duration;
		private Throwable err;
		private int depth;
        
        private EntryNode(String service, String path, String method, String biz, int depth) {
            this.service = service;
            this.path = path;
            this.method = method;
            this.biz = biz;
            this.depth = depth;
            this.startTime = System.currentTimeMillis();
        }

        /** 结束当前entry，并记录结束时间。 */
        private void end() {
            this.endTime = System.currentTimeMillis();
            this.duration = this.endTime - this.startTime;
        }
        
        
        /** 设置异常信息 */
        public void setErr(Throwable e) {
            this.err = e;
        }
    }
    
    

    private void pushCounter(EntryNode entry) {
    	Map<String, Object> tags = new HashMap<>();
    	tags.put("depth", entry.depth);
    	tags.put("service", entry.service);
    	tags.put("method", entry.method);
    	tags.put("path", entry.path);
    	tags.put("biz", entry.biz);
    	agent.push(Metric.newSUM("api.counter", tags, 1));
    }

	private void pushAvgDelayTime(EntryNode entry) {
		Map<String, Object> tags = new HashMap<>();
        tags.put("depth", entry.depth);
        tags.put("service", entry.service);
        tags.put("method", entry.method);
        tags.put("path", entry.path);
    	tags.put("biz", entry.biz);
        agent.push(Metric.newRate("api.avgDelayTime", tags, entry.duration));	
	}
    
	private void pushSuccRate(EntryNode entry) {
		Map<String, Object> tags = new HashMap<>();
        tags.put("depth", entry.depth);
        tags.put("service", entry.service);
        tags.put("method", entry.method);
        tags.put("path", entry.path);
    	tags.put("biz", entry.biz);
        agent.push(Metric.newRate("api.succRate", tags, entry.err == null ? 1:0));	
	}
	
    private void pushErrMetric(EntryNode entry) {
    	Map<String, Object> tags = new HashMap<>();
    	tags.put("depth", entry.depth);
    	tags.put("service", entry.service);
    	tags.put("method", entry.method);
    	tags.put("path", entry.path);
    	tags.put("biz", entry.biz);
    	tags.put("err", entry.err.getClass().getSimpleName());
    	
    	agent.push(Metric.newSUM("api.biz.err", tags, 1));
    }
}
