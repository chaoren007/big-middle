package com.morning.star.retail.utils.zk;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/13 14:20
 **/


import com.morning.star.retail.utils.StarNumFormat;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Calendar;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/13 16:46
 **/

public class zkUtils {
    private static final String COUNTER_ZNODE = "/zid/";
    private static final String ZK_SERVERS = "119.29.154.169:4180";
    static final int SESSION_OUTTIME = 15000;
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(800, 3);

    CuratorFramework cf = CuratorFrameworkFactory.builder()
            .connectString(ZK_SERVERS)
            .sessionTimeoutMs(SESSION_OUTTIME)
            .retryPolicy(retryPolicy)
            .build();

    public zkUtils()throws Exception {
        cf.start();
    }

    /**
     * 支持并发情况下的唯一自增ID
     * @param path 区分标识
     * @param lenth 4位月日  +  后接的自增编码长度
     * @return
     * @throws Exception
     */
    public String zkIncr(String path,Integer lenth) throws Exception{
        Calendar c = Calendar.getInstance();
        String MONTH = StarNumFormat.insertZore((c.get(Calendar.MONTH)+1),2);
        String DATA = StarNumFormat.insertZore(c.get(Calendar.DATE),2);
        DistributedAtomicLong distAtomicLong = new DistributedAtomicLong(cf, COUNTER_ZNODE+path+MONTH+DATA, retryPolicy);
        AtomicValue<Long> increment = distAtomicLong.increment();
        String code = StarNumFormat.insertZore(increment.postValue().intValue(), lenth);
        return MONTH+DATA+code;
    }
}

  
   