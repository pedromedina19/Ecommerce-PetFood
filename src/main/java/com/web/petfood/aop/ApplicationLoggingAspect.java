package com.web.petfood.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class ApplicationLoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationLoggingAspect.class);

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controllersPointcut() {
	}

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void servicesPointcut() {
	}

	@Around("controllersPointcut()")
	public Object logAroundController(ProceedingJoinPoint joinPoint) throws Throwable {

		logMethodName(joinPoint);
		logParametersReceived(joinPoint);
		Object result = joinPoint.proceed();
		String nomeDaView = getViewName(result);
		
		if (nomeDaView != null) {
			if (nomeDaView.startsWith("redirect:")) {
				logger.trace("Redirecionando para a URL: {}", nomeDaView.substring(9));
			} else {
				logger.trace("Encaminhando para a view: {}", nomeDaView);
			}
		}

		return result;
	}

	@Around("servicesPointcut()")
	public Object logAroundService(ProceedingJoinPoint joinPoint) throws Throwable {
		logMethodName(joinPoint);
		logParametersReceived(joinPoint);
		Object result = joinPoint.proceed();
		logger.trace("Retornando: {}", result);
		return result;
	}

	private Map<String, Object> getParameters(JoinPoint joinPoint) {
		CodeSignature signature = (CodeSignature) joinPoint.getSignature();
		HashMap<String, Object> map = new HashMap<>();
		String[] parameterNames = signature.getParameterNames();
		for (int i = 0; i < parameterNames.length; i++) {
			map.put(parameterNames[i], joinPoint.getArgs()[i]);
		}
		return map;
	}
	
	private void logMethodName(ProceedingJoinPoint joinPoint) {
		String nomeCompletoClasse = joinPoint.getSignature().getDeclaringTypeName();
		int posicaoPonto = nomeCompletoClasse.lastIndexOf(".");
		String nomeClasseApenas = (posicaoPonto != -1) ? nomeCompletoClasse.substring(posicaoPonto + 1) : nomeCompletoClasse;
		logger.trace("Entrou no método: {}.{}", nomeClasseApenas, joinPoint.getSignature().getName());
	}
	
	private void logParametersReceived(ProceedingJoinPoint joinPoint) {
		Map<String, Object> parametros = getParameters(joinPoint);
		if (!parametros.isEmpty()) {
			logger.debug("Parâmetros recebidos:");
			for (String nomeParametro : parametros.keySet()) {
				logger.debug("\t{}: {}", nomeParametro, parametros.get(nomeParametro));
			}
		}
	}
	
	private String getViewName(Object result) {
		String nomeDaView = null;
		if (result instanceof ModelAndView) {
			ModelAndView retorno = (ModelAndView) result;
			nomeDaView = retorno.getViewName();
		} else {
			if (result instanceof String) {
				nomeDaView = (String) result;
			}
		}
		return nomeDaView;
	}

}
