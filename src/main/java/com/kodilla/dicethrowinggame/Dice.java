package com.kodilla.dicethrowinggame;

public class Dice {
    private Die d1;
    private Die d2;
    private int value1;
    private int value2;
    private int total;
    private String dieLabel;

    public Dice() {
        Die d1 = new Die();
        this.d1 = d1;
        Die d2 = new Die();
        this.d2 = d2;
        value1 = 1;
        value2 = 1;
        total = 0;
    }


    public void rollDice() {

        d1.rollDie();
        d2.rollDie();
        System.out.println("Die #1:" + d1 + ", die #2:" + d2 + ".");
        total = d1.getNumberOfDotsOnTop() + d2.getNumberOfDotsOnTop();
    }

    public int getDiceSum() {
        total = getDie1() + getDie2();
        return total;
    }


    public int getDie1() {
        return d1.getNumberOfDotsOnTop();
    }

    public int getDie2() {
        return d2.getNumberOfDotsOnTop();
    }

    @Override
    public String toString() {
        return "The turn total is: " + total;
    }
}
