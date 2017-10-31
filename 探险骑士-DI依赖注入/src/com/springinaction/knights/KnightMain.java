package com.springinaction.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {

    public static void main(String[] args) throws Exception{
        // 基于xml的配置
        // 加载Spring应用上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights/knights.xml");
        // 获取knight bean
        Knight knight = context.getBean(Knight.class);
        // 使用knight
        knight.embarkOnQuest();
        context.close();

        // 基于java的配置
        AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight1 = annotation.getBean(Knight.class);
        knight1.embarkOnQuest();
        annotation.close();
    }
}
