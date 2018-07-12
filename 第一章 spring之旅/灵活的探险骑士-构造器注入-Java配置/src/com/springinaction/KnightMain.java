package com.springinaction;

import com.springinaction.config.KnightConfig;
import com.springinaction.knights.Knight;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shiwa
 */
public class KnightMain {

    public static void main(String []args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = (Knight) context.getBean("braveKnight");
        knight.embarkOnQuest();
        context.close();
    }
}
