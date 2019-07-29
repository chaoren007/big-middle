package com.morning.star.openfalcon;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.morning.star.openfalcon.profiler.TraceProfiler;

/**
 * 链路跟踪aop.
 * @author tim
 *
 */
@Aspect
public class TraceApsect {
    
    private TraceProfiler profiler;
    
    public TraceApsect(TraceProfiler profiler) {
		this.profiler = profiler;
	}

	@Around("execution(public * com.morning.star..*.*Service*.*(..)) || " +
			"execution(public * com.morning.star..*.*Controller*.*(..)) || " +
			"execution(public * com.morning.star..*.*Manager*.*(..)) || "  +
			"execution(public * com.morning.star..*.*Listener*.*(..))"
			)
	public Object methodAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
        	MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        	String method = sign.getMethod().getName();
        	String cls = joinPoint.getTarget().getClass().getSimpleName();
        	profiler.start(cls, method);
            return joinPoint.proceed();
        } catch (Exception e) {
        	profiler.error(e);
            throw e;
        } finally {
        	profiler.end();
        }
    }
}
