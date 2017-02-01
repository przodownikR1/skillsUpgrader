package pl.java.scalatech.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import pl.java.scalatech.annotation.LogEvent;

@Aspect
public class PointcutActionDef {

	@Pointcut("@annotation (logEvent)")
	public void eventLog(LogEvent logEvent) {
	}

	@Pointcut("execution(public * pl.java.scalatech.service..*.*(..))")
	public void serviceLog() {
	}

	@Pointcut("execution(public * pl.java.scalatech.service..*.*(..))")
	public void serviceExLog() {
	}
}