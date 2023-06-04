package ru.emelyanov.prac10.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConcreteFighter {
    private Fighter fighter;

    @Autowired
    public ConcreteFighter(@Qualifier("StreetFighter") Fighter fighter) {
        this.fighter = fighter;
    }

    public void goFight() {
        System.out.println("I'm " + fighter.doFight() + " fighter");
    }
}
