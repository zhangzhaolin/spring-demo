package concert;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

    public void execute(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("入座");
            System.out.println("手机静音");
            joinPoint.proceed();
            System.out.println("掌声雷动");
        } catch (Throwable throwable) {
            System.out.println("我要退款");
        }
    }

}
