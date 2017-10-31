package com.springinaction.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {

    public static void main(String[] args) throws Exception{
        // 基于xml的配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights/knights.xml");

        Knights knights = context.getBean(Knights.class);
        knights.embarkOnQuest();
        context.close();

        // 基于java的配置
        AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knights knights1 = annotation.getBean(Knights.class);
        knights1.embarkOnQuest();
        annotation.close();
    }
}
