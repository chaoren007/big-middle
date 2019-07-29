package com.morning.star.openfalcon.agent;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Metric {
   
    private String endpoint;    // 最核心的字段，代表这个采集项具体度量的是什么, 比如是cpu_idle呢，还是memory_free, 还是qps
    private String metric;      // 标明Metric的主体(属主)，比如metric是cpu_idle，那么Endpoint就表示这是哪台机器的cpu_idle
    private String tags;        // 一组逗号分割的键值对, 对metric进一步描述和细化, 可以是空字符串. 比如idc=lg，比如service=xbox等，多个tag之间用逗号分割
    private String counterType; // 只能是COUNTER或者GAUGE二选一，前者表示该数据采集项为计时器类型，后者表示其为原值 (注意大小写)
                                // GAUGE：即用户上传什么样的值，就原封不动的存储
                                // COUNTER：指标在存储和展现的时候，会被计算为speed，即（当前值 - 上次值）/ 时间间隔
    private double value;       // 代表该metric在当前时间点的值，float64
    private int step;           // 表示该数据采集项的汇报周期，这对于后续的配置监控策略很重要，必须明确指定。
    private int timestamp;      // 表示汇报该数据时的unix时间戳，注意是整数，代表的是秒
    
    
    public static Metric newCounter(String metric, Map<String, Object> tags, double value) {
        return new Metric(NetUtils.getHostName(), metric, toTagStr(tags), MetricType.COUNTER, value, 60, (int)(System.currentTimeMillis() / 1000));
    }
    
    
    public static Metric newGauge(String metric, Map<String, Object> tags, double value) {
        return new Metric(NetUtils.getHostName(), metric, toTagStr(tags), MetricType.GAUGE, value, 60, (int)(System.currentTimeMillis() / 1000));
    }
    
    public static Metric newSUM(String metric, Map<String, Object> tags, double value) {
		return new Metric(NetUtils.getHostName(), metric, toTagStr(tags), MetricType.SUM, value, 60, (int)(System.currentTimeMillis() / 1000));
	}
    
    public static Metric newRate(String metric, Map<String, Object> tags, double value) {
    	return new Metric(NetUtils.getHostName(), metric, toTagStr(tags), MetricType.RATE, value, 60, (int)(System.currentTimeMillis() / 1000));
    }
    
    public Metric(String endpoint, String metric, String tags, String counterType, double value, int step,
            int timestamp) {
        this.endpoint = endpoint;
        this.metric = metric;
        this.tags = tags;
        this.counterType = counterType;
        this.value = value;
        this.step = step;
        this.timestamp = timestamp;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
    
    public static String toTagStr(Map<String, Object> tags) {
        if(tags == null || tags.isEmpty()) {
            return null;
        }
        // 排序
        Map<String, Object> sortTags = new TreeMap<>();
        sortTags.putAll(tags);
        
        // 拼接成字符串
        StringBuilder sb = new StringBuilder();
        for(Entry<String, Object> e : sortTags.entrySet()) {
            if(sb.length() > 0) {
                sb.append(",");
            }
            sb.append(e.getKey()).append("=").append(e.getValue());
        }
        return sb.toString();
    }
}
