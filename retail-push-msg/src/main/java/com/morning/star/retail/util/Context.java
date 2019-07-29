package com.morning.star.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


/**
 * Spring Context.
 * 
 * @author Tim
 *
 */
@Component
public class Context {

	private static ApplicationContext context;

	
	@Autowired(required = true)
	public void setApplicationContext(ApplicationContext context) {
		Context.context = context;
	}

	public static <T> T getBean(Class<T> type) {
		return context.getBean(type);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T)context.getBean(name);
	}
	
	public static void publish(ApplicationEvent event) {
		context.publishEvent(event);
	}

}