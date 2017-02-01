package pl.java.scalatech.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExceptionLogger {

	@AfterThrowing(pointcut = "PointcutActionDef.serviceExLog()", throwing = "ex")
	public Object logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		log.error("Unexcpected error ....", ex);
		String logPrefix = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
	//	  User user = SecurityContextUtilTools.getCurrentUser();
		// TODO
		// userManager.logoutAction(user.getLogin());
		//String ip = user != null ? user.getIp() : "";
		String[] descTab = logPrefix.split("\\.");
		int pos = descTab.length;
		String description;
		if (pos > 2) {
			description = descTab[pos - 2] + "." + descTab[pos - 1];
		} else {
			description = logPrefix;
		}
		String formOrModuleName = joinPoint.getSignature().getDeclaringTypeName();
		String[] formOrModule = formOrModuleName.split("\\.");
		int posForm = formOrModule.length;
		String moduleName;
		if (pos > 2) {
			moduleName = formOrModule[posForm - 2] + "." + formOrModule[posForm - 1];
		} else {
			moduleName = logPrefix;
		}
		String msg = ex.getMessage();
		if (msg == null)
			msg = "undefided";

		//loggerService.persistUnexpectedException(new UnExpectedException(ex.toString(), msg, description, ip, user, moduleName, logPrefix, formOrModuleName));

		return ex;
	}

}
