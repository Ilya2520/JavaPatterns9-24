package ru.emelyanov.prac10.models;

import org.springframework.stereotype.Component;

@Component("StreetFighter")
public class StreetFighter implements Fighter {
    public String doFight() {return "Street Fighter";}
}
