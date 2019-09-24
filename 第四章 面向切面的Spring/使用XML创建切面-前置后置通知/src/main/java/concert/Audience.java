package concert;

import org.aspectj.lang.annotation.*;


public class Audience {

    public void silenceCellPhone() {
        System.out.println("手机静音");
    }

    public void takeSeats() {
        System.out.println("对号入座");
    }

    public void applause() {
        System.out.println("掌声雷动");
    }

    public void demandRefund() {
        System.out.println("我想退款!");
    }

}
