package com.springinaction;

import com.springinaction.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {

    public static void main(String []args){
        // 通过xml的方式 加载spring上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
        // 获取 knight bean
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
