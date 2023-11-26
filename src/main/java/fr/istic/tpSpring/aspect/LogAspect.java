package fr.istic.tpSpring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * PointCut sur les controllers API
     */
    @Pointcut("within(fr.istic.tpSpring.rest.*)")
    public void inRestLayer() {
    }

    /**
     * Inform the start of a method in the rest layer
     * @param joinPoint
     */
    @Before("inRestLayer()")
    public void logMethodStart(JoinPoint joinPoint){
        log.debug("Exécution de la methode " + joinPoint.getSignature());
    }
}