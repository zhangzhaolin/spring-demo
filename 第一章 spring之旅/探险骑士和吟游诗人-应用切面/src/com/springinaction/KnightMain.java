package com.springinaction;

import com.springinaction.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {

    public static void main(String []args){
        // 通过xml的方式 加载spring上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights.xml");
        // 获取 knight bea
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
