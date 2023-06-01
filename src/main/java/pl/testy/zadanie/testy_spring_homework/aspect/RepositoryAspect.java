package pl.testy.zadanie.testy_spring_homework.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.util.ObjectMapperUtil;
import pl.testy.zadanie.testy_spring_homework.util.SecurityUtil;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class RepositoryAspect {

    private static final String MESSAGE_FORMAT = "User - %s\n" +
            "Method signature - %s\n" +
            " Execution time - [%s]\n" +
            " Duration - [%sms]\n" +
            " Input - %s\n" +
            " Output - %s";

    private final ObjectMapperUtil objectMapper;
    private final SecurityUtil securityUtil;

    @Pointcut("within(pl.testy.zadanie.testy_spring_homework.repository..*)")
    private void inRepositoryPackage() {
    }

    @Pointcut("@within(org.springframework.stereotype.Repository) && inRepositoryPackage() " +
            "&& execution(* *..find*(..))")
    public void repositoryMethodPointcut() {

    }

    @Around("repositoryMethodPointcut()")
    public Object logRequestAndResponse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //request
        log.info("Invocate of method {}", proceedingJoinPoint.getSignature());

        //before
        List<String> args = Arrays.stream(proceedingJoinPoint.getArgs())
                .map(objectMapper::toJson)
                .toList();

        log.info(createArgumentString(args));


        long timestampBeforeExecution = System.currentTimeMillis();

        //execute
        Object result = proceedingJoinPoint.proceed();

        //after
        long duration = System.currentTimeMillis() - timestampBeforeExecution;


        //response
        log.info(String.format(MESSAGE_FORMAT,
                securityUtil.getCurrentUsername(),
                proceedingJoinPoint.getSignature(),
                LocalDateTime.now(),
                duration,
                createArgumentString(args),
                objectMapper.toJson(result)));

        return result;
    }

    private String createArgumentString(List<String> args) {
        return StringUtils.join(args, '\n');
    }


}
