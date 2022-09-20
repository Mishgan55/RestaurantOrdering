package khorsun.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class CustomAspect {


    private static final Logger log = Logger.getLogger(CustomAspect.class);



    @Pointcut("execution(* khorsun.app.dao.CustomerDAO.*(..))")
    public void aroundRepositoryPointcut() {
    }

    @Around("aroundRepositoryPointcut()")
    public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        log.info("Method " + joinPoint.getSignature().getName() + " start");

        Object proceed = joinPoint.proceed();

        log.info("Method " + joinPoint.getSignature().getName() + " finished");
        stopWatch.stop();
        System.out.println("time to execute method = "+stopWatch.getLastTaskTimeMillis()+" milliseconds");
        return proceed;
    }

}
