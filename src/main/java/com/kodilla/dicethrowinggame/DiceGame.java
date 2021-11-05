package com.kodilla.dicethrowinggame;

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {

        PlayerCommunication playerCommunication = new PlayerCommunication();
        playerCommunication.gameStart();

        Dice dice = new Dice();
        int turnTotal = 0;
        int computerTotal = 0;
        int playerTotal = 0;
        int turnOver = 1;
        int winner = 21;

        Scanner playerAnswer = new Scanner(System.in);
        String answer;

        do {
            if (playerTotal <= winner) {
                playerCommunication.playerTurn();
                do {
                    System.out.println("Type 'y' if ready and 'n' to end turn.");
                    answer = playerAnswer.next();

                    if (answer.equalsIgnoreCase("y") && playerTotal <= winner) {
                        dice.rollDice();
                        System.out.println(dice);

                        if (dice.getDie1() == turnOver || dice.getDie2() == turnOver) {
                            System.out.println("You rolled 1. Your turn is over.");
                            System.out.println("Please type 'C' when you are ready to turn the dice over to the Computer.");
                            answer = playerAnswer.next();
                            System.out.println("\nIt's a computer's turn\n");
                        } else {
                            turnTotal = turnTotal + dice.getDiceSum();
                            playerTotal = playerTotal + dice.getDiceSum();
                            System.out.println("Your grand total: " + playerTotal);
                        }
                    }
                }

                while (answer.equalsIgnoreCase("y") && playerTotal <= winner);
                turnTotal = 0;
                int endComputerTurn = 20;
                boolean endCompTurn = false;

                do {
                    if (turnTotal <= endComputerTurn && playerTotal <= winner) {
                        dice.rollDice();
                        System.out.println(dice);
                        if (dice.getDie1() == turnOver || dice.getDie2() == turnOver) {
                            System.out.println("The computer rolled 1. The computer's turn is over.\n");
                            endCompTurn = true;
                        } else {
                            turnTotal = turnTotal + dice.getDiceSum();
                            computerTotal = computerTotal + dice.getDiceSum();
                            System.out.println("the computer's turn total is: " + turnTotal);
                            System.out.println("The computer's grand total is: " + computerTotal);
                        }
                    }
                }

                while (turnTotal <= endComputerTurn && !endCompTurn && playerTotal <= winner);
                turnTotal = 0;
            }
        }

        while (playerTotal <= winner && computerTotal <= winner);

        if (playerTotal >= winner)
            System.out.println("\nYou win!");
        else
            System.out.println("\nYou lose!");

    }
}
