package com.morning.star.openfalcon.agent;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Send Monitor Report Utils.
 * @author Tim
 *
 */
public class OpenFalconAgent {
    private final static Logger LOGGER = LoggerFactory.getLogger(OpenFalconAgent.class);
    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10000);
    private ExecutorService service = new ThreadPoolExecutor(3, 3,
            0L, TimeUnit.MILLISECONDS,
            queue, new DaemonFactory());
    
    private CloseableHttpClient client = HttpClients.createDefault();
    private RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setSocketTimeout(5000)
            .setConnectTimeout(1000)
            .setConnectionRequestTimeout(1000)
            .build();
    
    private void postJson(String url, String json) throws ClientProtocolException, IOException {
        HttpPost post = new HttpPost(url);
        post.setConfig(defaultRequestConfig);
        
        StringEntity s = new StringEntity(json);
        s.setContentType("application/json");
        post.addHeader("Content-Type", "application/json");
        post.setEntity(s);
        try(CloseableHttpResponse response = client.execute(post)) {
            
        } catch (IOException e) {
            LOGGER.error("Send POST request failed: {}", url, e);
        }
    }
    
    public void push(Metric metric) {
        try {
            if(MetricType.SUM.equals(metric.getCounterType()) || MetricType.RATE.equals(metric.getCounterType())) {
                ReportInfo reportInfo = getReportInfo(metric);
                reportInfo.addValue(metric.getValue());
                reportInfo.addCount();
            } else {
                service.execute(new PushTask(metric));
            }
        } catch (Exception e) {
            LOGGER.error("commit falcon task error", e);
        }
    }
    
    private class PushTask implements Runnable {
        private Metric metric;
        
        public PushTask(Metric metric) {
            this.metric = metric;
        }
        
        @Override
        public void run() {
            try {
                postJson("http://127.0.0.1:1988/v1/push", Json.toJson(Arrays.asList(metric)));
            } catch (Exception e) {
                LOGGER.error("push falcon task error", e);
            }
        }
    }
    
    
    private Map<String, ReportInfo> mapReportList = new ConcurrentHashMap<>();       //用于统计
    
    private ReportInfo getReportInfo(Metric metric) {
        int timestamp = ReportInfo.toReportTimestamp(metric.getTimestamp(), metric.getStep());
        String key = metric.getEndpoint() + "." + metric.getMetric() + "." + metric.getTags() + "." + timestamp;
        ReportInfo reportInfo = mapReportList.get(key);
        if(reportInfo == null) {
            synchronized (mapReportList) {
                reportInfo = mapReportList.get(key);
                if(reportInfo == null) {
                    reportInfo = new ReportInfo(metric.getEndpoint(), metric.getMetric(), metric.getTags(), metric.getCounterType(), metric.getStep(), timestamp);
                    mapReportList.put(key, reportInfo);
                }
            }
        }
        return reportInfo;          
    }
    
    private void flush() {
    	Iterator<Entry<String, ReportInfo>> ite = mapReportList.entrySet().iterator();
        int now = (int)(System.currentTimeMillis() / 1000);
        while(ite.hasNext()) {
            ReportInfo reportInfo = ite.next().getValue();
            if(reportInfo.getTimestamp() != ReportInfo.toReportTimestamp(now, reportInfo.getStep())) { //时间戳不一样
                Metric metric = reportInfo.toMetric();
                if(metric != null) {
                    this.push(metric);
                }
                ite.remove();
            }
        }
//        LOGGER.info("openfalcon: report num: " + mapReportList.size() + ", submit task num:" + queue.size());
    }
    
    public OpenFalconAgent() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while(true){
                    try {
                        flush();
                    } catch (Exception e) {
                        LOGGER.error("submit openfalcon task error", e);
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }               
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
    
    
    private static class ReportInfo implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 7526260659253377220L;

        private double value;
        private long counter;
        
        private final String endpoint;
        private final String metric;
        private final String tags;
        private final String counterType;
        private final int step;
        private final int timestamp;


        public ReportInfo(String endpoint, String metric, String tags, String counterType,
                int step, int timestamp) {
            this.endpoint = endpoint;
            this.metric = metric;
            this.tags = tags;
            this.counterType = counterType;
            this.step = step;
            this.timestamp = timestamp;
        }

        public double getValue() {
            return value;
        }

        public long getCounter() {
            return counter;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public String getMetric() {
            return metric;
        }

        public String getTags() {
            return tags;
        }

        public String getCounterType() {
            return counterType;
        }

        public int getStep() {
            return step;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void addValue(double value) {
            this.value += value;
        }

        public void addCount() {
            this.counter++;
        }
        
        public static int toReportTimestamp(int timestamp, int step) {
            return timestamp - (timestamp % step);
        }
        
        public Metric toMetric() {
            if(MetricType.SUM.equals(getCounterType())) {
                return new Metric(getEndpoint(), 
                        getMetric(), getTags(), 
                        MetricType.GAUGE, 
                        getCounter(), 
                        getStep(), getTimestamp());
            } else if(MetricType.RATE.equals(getCounterType())) {
                if(getCounter() != 0) {
                    return new Metric(getEndpoint(), 
                            getMetric(), getTags(), 
                            MetricType.GAUGE, 
                            getValue() / getCounter(), 
                            getStep(), getTimestamp());
                }
            }
            return null;
        }
        
    }
    
    
    private static class DaemonFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("open-falcon");
            t.setDaemon(true);
            return t;
        }
    }


}
