package com.kodilla.dicethrowinggame;

import java.util.Random;

public class Die {

    private int numberOfDotsOnTop;
    private final int MAX = 6;
    private Random randomDieRoll;


    public Die() {
        numberOfDotsOnTop = 1;
        randomDieRoll = new Random();
    }

    public void rollDie() {
        numberOfDotsOnTop = randomDieRoll.nextInt(MAX) + 1;
    }


    public int getNumberOfDotsOnTop() {
        return numberOfDotsOnTop;
    }

    public String toString() {
        String result = " " + numberOfDotsOnTop;
        return result;
    }

}

