package com.springinaction;

import com.springinaction.config.KnightConfig;
import com.springinaction.knights.Knight;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.springinaction.config.KnightConfig.class);
        Knight knight = (Knight)context.getBean("braveKnight");
        knight.embarkOnQuest();
    }
}
