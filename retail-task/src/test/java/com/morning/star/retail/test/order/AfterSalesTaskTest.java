package com.morning.star.retail.test.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.morning.star.retail.task.order.AfterSalesCheckMissedRefundOrderTask;
import com.morning.star.retail.task.order.AfterSalesCheckRefundSuccessTask;
import com.morning.star.retail.task.order.AfterSalesRejectionCloseOrderTask;
import com.morning.star.retail.task.order.AfterSalesStockCheckTask;
import com.morning.star.retail.task.order.StatementOrderGenerateTask;

/**
 * Created by liangguobin on 2017/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/spring/dubbo-provider.xml"})
public class AfterSalesTaskTest {

    @Autowired
    private AfterSalesStockCheckTask salesStockCheckTask;


    @Autowired
    private AfterSalesRejectionCloseOrderTask rejectionCloseOrderTask;


    @Autowired
    private AfterSalesCheckRefundSuccessTask refundSuccessTask;

    @Autowired
    private AfterSalesCheckMissedRefundOrderTask missedRefundOrderTask;
    
    @Autowired
    private StatementOrderGenerateTask orderGenerateTask;
    @Test
    public void testStockCheckTask() {
        salesStockCheckTask.execute();
    }


    @Test
    public void testAfterSales() {
        rejectionCloseOrderTask.execute();
    }

    @Test
    public void testRefundSuccessTask() {
        refundSuccessTask.execute();
    }


    @Test
    public void testMissedRefundOrderTask() {
        missedRefundOrderTask.execute();
    }
    
    @Test
    public void testStatementOrderGenerateTask() {
    	orderGenerateTask.run();
    }
    
    
    @Test
    public void test(){
    	
    }
    
}
