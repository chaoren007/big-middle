package com.morning.star.retail.task.order;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.facade.StatementOrderServiceFacade;
@Service
public class StatementOrderGenerateTask implements Runnable{
	 private static final Logger logger = LoggerFactory.getLogger(StatementOrderGenerateTask.class);
	 
	 @Autowired private StatementOrderServiceFacade statementServiceFacade;
	 
	  @Override
	    public void run() {
		  try {
			logger.info("--start---------StatementOrderGenerateTask-------------------");
			generateOrder();
			logger.info("--end---------StatementOrderGenerateTask-------------------");
		} catch (Exception e) {
			logger.info("--Exception---------StatementOrderGenerateTask-------------------exception:{}",e.toString());
			//e.printStackTrace();
		}
	  }
	  
	  /**
	 * 生成账期(每天零点执行一次)
	 * @throws ParseException 
	 */
	private void generateOrder() throws Exception{
		statementServiceFacade.generateStatementOrder("daojia");
	  }
}
