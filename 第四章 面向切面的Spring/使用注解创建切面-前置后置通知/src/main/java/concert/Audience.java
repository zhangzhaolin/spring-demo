package concert;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {
    }

    // @Before("execution(* concert.Performance.perform(..))")
    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("手机静音");
    }

    // @Before("execution(* concert.Performance.perform(..))")
    @Before("performance()")
    public void taskSeat() {
        System.out.println("入座");
    }

    // @After("execution(* concert.Performance.perform(..))")
    @After("performance()")
    public void applause() {
        System.out.println("掌声雷动");
    }

    // @AfterThrowing("execution(* concert.Performance.perform(..))")
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("我要退款");
    }

}
