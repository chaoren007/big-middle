package com.morning.star.log;


import java.lang.reflect.Method;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

@Aspect
public class MethodAroundLoggerAspect {

	@Value("${spring.application.name}")
	private String serviceName;

	protected Logger logger = LoggerFactory.getLogger("com.morning.star.ML");

	protected Logger loggerM = LoggerFactory.getLogger("com.morning.star.monitor");

	// traceStack用于记录方法轨迹，每个方法开始会push一个标识，方法结束会pop标识，当traceStack为空时表示调用链结束
	private static TraceStack<MDCContext> traceStack = new TraceStack<>();

	private ArrayList<Class<?>> excludeClasses = new ArrayList<>();

	protected MethodAroundLoggerAspect() {
		try {
			Class<?> servletRequest = Class.forName("javax.servlet.ServletRequest");
			excludeClasses.add(servletRequest);
		} catch (Exception e) {
		}

		try {
			Class<?> servletResponse = Class.forName("javax.servlet.ServletResponse");
			excludeClasses.add(servletResponse);
		} catch (Exception e) {
		}
	}

	@Around("execution(public * com.morning.star..*.*Service.*(..)) || " +
			"execution(public * com.morning.star..*.*Application.*(..)) || " +
			"execution(public * com.morning.star..*.*Controller.*(..)) || " +
			"execution(public * com.morning.star..*.*Facade.*(..)) || " +
			"execution(public * com.morning.star..*.*ServiceHelper*.*(..))")
	public Object methodAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		LogContext.createRequestIfNecessary();		// 如果上下文没有requestId，则创建

        
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();


        long startTime = System.currentTimeMillis();

        String className = getClassName(joinPoint);
        String methodName = joinPoint.getSignature().getName();

        // 解析参数
        String argInfo = getArgsInfo(joinPoint, methodSignature);

        Class<?> returnType = methodSignature.getReturnType();
        // 是否存在返回值
        boolean noReturnValue = Void.class.equals(returnType) || Void.TYPE.equals(returnType);
        Object retVal = null;
        
        MDCContext mdc = new MDCContext();
        mdc.setClassName(className);
        mdc.setMethodName(methodName);
        mdc.setRequestId(LogContext.getRequestId());

		mdc.setTraceId(LogContext.getTraceId());
		mdc.setSpanId(LogContext.getSpanId());
		mdc.setParentSpanId(LogContext.getParentSpanId());
		mdc.setServiceName(serviceName);
		if(LogContext.getOtherInfo() != null) {
			mdc.setOtherInfo(JSON.toJSONString(LogContext.getOtherInfo()));
		} else {
			mdc.setOtherInfo("{}");
		}
        traceStack.push(mdc);
        try {
            mdc.applyAll();
	        mdc.applyReceivedTime(startTime);
            logger.info("MSRequest|" + argInfo);
            // 执行方法
            if (noReturnValue) {
                joinPoint.proceed(joinPoint.getArgs());
            }
            else {
                retVal = joinPoint.proceed(joinPoint.getArgs());
            }
            mdc.applyTime(System.currentTimeMillis() - startTime);
	        mdc.applySendTime(System.currentTimeMillis());
            // 输出结果
            logger.info("MSResponse|" + (noReturnValue ? "void" : objectToString(retVal)));

            // otherInfo可能会在程序中设值，需要再调用方法后再次设值
	        if(LogContext.getOtherInfo() != null) {
		        mdc.setOtherInfo(JSON.toJSONString(LogContext.getOtherInfo()));
	        } else {
		        mdc.setOtherInfo("{}");
	        }
	        mdc.applyOtherInfo();
	        loggerM.info("");
        }
        catch (Throwable ex) {
            mdc.applyTime(System.currentTimeMillis() - startTime);
            // 输出异常
            logger.error("MSException|" + argInfo, ex);
            // 把当前的requestId放到errRequestId
            LogContext.setRequestToErr();
            throw ex;
        } finally {
            traceStack.pop();
            if(traceStack.isEmpty()) {  // 上一个调用链结束
                LogContext.clearLogContext();
                MDCContext.clear();
            } else {
                traceStack.last().applyAll();
            }
        }
        return retVal;
		
	}


	private String getClassName(ProceedingJoinPoint joinPoint) {
		Object o = joinPoint.getTarget();

		return o.getClass().getSimpleName();
	}

	private static String[] getMethodParamNames(Method method) {
		String[] names =  new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
		if(names == null) {	// 如果当前执行的方法就是代理方法
			int len = method.getParameterCount();
			names = new String[len];
			for(int i = 0; i < len; i++) {
				names[i] = String.valueOf(i);
			}
		}
		return names;
	}

	// 解析方法参数
	private String getArgsInfo(ProceedingJoinPoint joinPoint, MethodSignature methodSignature) {
		String[] paramNames = getMethodParamNames(methodSignature.getMethod());
		Object[] paramValues = joinPoint.getArgs();

		StringBuilder sb = new StringBuilder();

		if (paramValues != null && paramValues.length > 0) {
			int paramLen = paramValues.length;
			for (int i = 0; i < paramLen; ++i) {
				if(i > 0) {
					sb.append(", ");
				}

				if(paramValues[i] != null) {
					sb.append(paramNames[i] + ":" + objectToString(paramValues[i]));
				} else {
					sb.append(paramNames[i] + ":null");
				}
			}
		}

		return sb.toString();
	}

	/**
	 *
	 * @param o
	 * @return
	 */
	private String objectToString(Object o) {
		if(o == null) {
			return "null";
		}


		try {
			for(Class<?> excludeClass : excludeClasses) {
				if(excludeClass.isAssignableFrom(o.getClass())) {
					return excludeClass.getName();
				}
			}

			// 基本对象，转为String
			if (isBasicType(o)) {
				return  String.valueOf(o);
			}

			if (o instanceof String) {
				return (String) o;
			}

			return LogJsonParser.parse(o);
		} catch (Exception e) {
			e.printStackTrace();
			return "parse err";
		}
	}

	private boolean isBasicType(Object o) {
		return o instanceof Integer || o instanceof Long || o instanceof Float || o instanceof Double || o instanceof Short ||
				o instanceof Boolean || o instanceof Byte || o instanceof Character;
	}
}
