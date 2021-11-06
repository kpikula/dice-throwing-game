package com.kodilla.dicethrowinggame;

import java.util.Random;

public class Die {

    private int numberOfDotsOnTop;
    private Random randomDieRoll;


    public Die() {
        numberOfDotsOnTop = 1;
        randomDieRoll = new Random();
    }

    public void rollDie() {
        int MAX = 6;
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

