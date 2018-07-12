package com.springinaction;

import com.springinaction.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knight.xml");
        Knight knight = (Knight)context.getBean("braveKnight");
        knight.embarkOnQuest();
        context.close();
    }
}
