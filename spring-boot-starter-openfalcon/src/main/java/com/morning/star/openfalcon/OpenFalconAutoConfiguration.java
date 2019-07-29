package com.morning.star.openfalcon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.morning.star.openfalcon.agent.OpenFalconAgent;
import com.morning.star.openfalcon.profiler.TraceProfiler;

@Configuration
@EnableAspectJAutoProxy
public class OpenFalconAutoConfiguration {
	
    @Bean
    public TraceApsect traceApsect(TraceProfiler profiler) {
        return new TraceApsect(profiler);
    }
    
    @Bean
    public TraceProfiler traceProfiler(OpenFalconAgent agent) {
    	return new TraceProfiler(agent);
    }
    
    @Bean
    public OpenFalconAgent openFalconAgent() {
    	return new OpenFalconAgent();
    }

}
