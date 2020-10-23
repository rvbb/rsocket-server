package com.rvbb.b2b.rsocket.server.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Aspect
@Configuration
@Slf4j
public class LoggerConfig {

    /*https://medium.com/@azizulhaq.ananto/how-to-handle-logs-and-tracing-in-spring-webflux-and-microservices-a0b45adc4610*/
    @Around("@annotation(com.rvbb.b2b.rsocket.server.util.Logger)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        if (result instanceof Mono) {
            Mono monoResult = (Mono) result;
            return monoResult
                    .doOnSuccess(o -> {
                        Object response = "";
                        if (Objects.nonNull(o)) {
                            response = o.toString();
                        }
                        log.info("Enter: {}.{}() with argument[s] = {}",
                                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
                                joinPoint.getArgs());
                        log.info("Exit: {}.{}() had arguments = {}, with result = {}, Execution time = {} ms",
                                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
                                joinPoint.getArgs()[0],
                                response, (System.currentTimeMillis() - start));
                    });
        } else {
            log.debug("joinPoint is not mono, it =[{}]", joinPoint);
            return "";
        }
    }
}
