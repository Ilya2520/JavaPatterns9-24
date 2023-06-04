package ru.emelyanov.prac10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.emelyanov.prac10.config.BeanConfig;
import ru.emelyanov.prac10.models.ConcreteFighter;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ConcreteFighter concreteFighter = context.getBean(ConcreteFighter.class);
        concreteFighter.goFight();
    }
}
