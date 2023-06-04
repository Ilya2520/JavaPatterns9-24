package ru.emelyanov.prac10.models;

import org.springframework.stereotype.Component;

@Component("Boxer")
public class Boxer implements Fighter{
    public String doFight(){return "Boxer";}
}
