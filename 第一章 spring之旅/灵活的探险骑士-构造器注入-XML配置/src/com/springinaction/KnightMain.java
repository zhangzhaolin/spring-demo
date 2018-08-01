package com.springinaction;

import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knight.xml");
        BraveKnight braveKnight = (BraveKnight) context.getBean("braveKnight");
        braveKnight.embarkOnQuest();
    }
}
