package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(public * concert.Performance.perform())")
    public void perform(){}

    @Around("perform()")
    public void execute(ProceedingJoinPoint joinPoint){
        System.out.println("入座");
        System.out.println("关闭手机");
        try {
            joinPoint.proceed();
            System.out.println("掌声雷动");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("我要退款~");
        }
    }
}
