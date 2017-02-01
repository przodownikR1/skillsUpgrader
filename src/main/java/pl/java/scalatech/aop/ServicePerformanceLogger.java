package pl.java.scalatech.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component("loggerAOP")
@Slf4j
public class ServicePerformanceLogger {


	@Around("PointcutActionDef.serviceLog()")
	public Object O(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(pjp.getSignature().getName());
		Object returnValue = pjp.proceed();
		sw.stop();
		log.trace(" method : " + pjp.getSignature().getName() + "  time:  " + sw.prettyPrint());
		return returnValue;
	}

}