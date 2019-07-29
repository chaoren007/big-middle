package com.morning.star.retail.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AsyncSetter<T> {


    List<Consumer<T>> consumers = new ArrayList<>();
    private Executor executor;
    private T original;

    private int timeout;

    AsyncSetter(Executor executor, int timeout) {
        this.executor = executor;
        this.timeout = timeout;
    }

    public AsyncSetter<T> setOriginal(T original) {
        this.original = original;
        return this;
    }

    public AsyncSetter<T> addRunnable(Consumer<T> c) {
        consumers.add(c);
        return this;
    }

    public void execute() {
        CountDownLatch countDownLatch = new CountDownLatch(consumers.size());
        for (Consumer c : consumers) {
            executor.execute(() -> {
                try {
                    c.accept(original);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        monitoringLog();


        boolean await = false;
        try {
            await = countDownLatch.await(timeout, TimeUnit.SECONDS);
            if (!await) {
                System.out.println("AsyncSetter[{}]执行未完成" + this.hashCode());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void monitoringLog() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();

        ThreadPoolExecutor threadPoolExecutor = ((ThreadPoolTaskExecutor) this.executor).getThreadPoolExecutor();
        objectNode.put("PoolSize", threadPoolExecutor.getPoolSize());
        objectNode.put("CompletedTaskCount", threadPoolExecutor.getCompletedTaskCount());
        objectNode.put("LargestPoolSize", threadPoolExecutor.getLargestPoolSize());
        objectNode.put("TaskCount", threadPoolExecutor.getTaskCount());
    }

    public T getOriginal() {
        return original;
    }

}
