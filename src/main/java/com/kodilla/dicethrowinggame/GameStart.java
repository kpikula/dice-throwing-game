package com.kodilla.dicethrowinggame;

import java.util.Locale;
import java.util.Scanner;

public class GameStart {
    public void gameStart() {
        System.out.println("Rules of the Game");
        System.out.println("1) You play against the computer.");
        System.out.println("2) You play by rolling two dice.");
        System.out.println("3) The first player who reaches 100 points wins.");
        System.out.println("4) When a player rolls a 1, the turn is over.");
        System.out.println("5) After each turn, points are reset to 0");
        System.out.println("6) The computer's turn is over when turn grand total reaches 20 points.\n");

        Scanner in = new Scanner( System.in );
        System.out.println("Please, enter your name");
        String playerName = in.nextLine();
        playerName = playerName.toUpperCase(Locale.ROOT);
        System.out.println("Hello, " + playerName + ". Let's start the game!\n");
    }
}
