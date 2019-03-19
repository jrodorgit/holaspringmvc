package net.rodor.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LogginAspect {

	@Before("execution(* net.rodor.springmvc.TipoPermisoServiceImpl.save(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("----------- Llamando al servicio:"+((MethodSignature)joinPoint.getSignature()).getMethod().getDeclaringClass()  );
		System.out.println("----------- Llamando al metodo:"+((MethodSignature)joinPoint.getSignature()).getMethod().getName()   );
		//System.out.println("Llamando al servicio:"+(joinPoint.)   );
		Object[] args = joinPoint.getArgs();
		for(Object arg: args){
			System.out.println("----------- Con parametro:"+arg.toString());
			
		}
		
		// Aqui podriamos utilizar log4j para trazar el acceso a este servicio.
		
	}
}
