package com.springinaction;

import com.springinaction.config.KnightConfig;
import com.springinaction.knights.Knight;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {

    public static void main(String []args){
        // 通过java配置的方式 加载spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        // 获取 knight bean
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
