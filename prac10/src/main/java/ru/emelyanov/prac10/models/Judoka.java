package ru.emelyanov.prac10.models;

import org.springframework.stereotype.Component;

@Component("Judoka")
public class Judoka implements Fighter{
    public String doFight(){return "Judoka";}
}
