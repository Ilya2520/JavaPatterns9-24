package ru.emelyanov.prac13;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${program.Student.name}")
    private String name;
    @Value("${program.Student.last_name}")
    private String last_name;
    @Value("${program.Student.group}")
    private String group;

    @PostConstruct
    public void init(){
        System.out.println(name+" "+last_name+" from group: "+group);
    }
}
