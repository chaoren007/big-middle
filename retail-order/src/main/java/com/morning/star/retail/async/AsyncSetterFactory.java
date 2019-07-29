package com.morning.star.retail.async;

import java.util.concurrent.Executor;

public class AsyncSetterFactory {

    private Executor executor;

    private int timeout;


    public AsyncSetterFactory (Executor executor, int timeout){
        this.executor = executor;
        this.timeout = timeout;
    }

    public AsyncSetter getAsyncSetter(){
        return new AsyncSetter(executor, timeout);
    }
}
