package concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    // @Pointcut("execution(public * concert.Performance.perform(..)) && bean(performance)")
    @Pointcut("execution(* concert.Performance.perform(..)) && bean(musicPerformance)")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhone(){
        System.out.println("手机静音");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("对号入座");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("掌声雷动");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("我想退款!");
    }

}
