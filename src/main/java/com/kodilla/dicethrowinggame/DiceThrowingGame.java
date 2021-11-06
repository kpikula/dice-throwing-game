package com.kodilla.dicethrowinggame;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DiceThrowingGame extends Application {
    int playerTurnTotal = 0;
    int computerTurnTotal = 0;
    int computerTotal = 0;
    int playerTotal = 0;
    final int turnOver = 1;
    final int winner = 21;
    private boolean myTurn = true;

    private final Image imageback = new Image("file:src/main/resources/scene_2.png");

    private final Label playerTurnScoreLabel = new Label("Turn Score");
    private final Label computerTurnScoreLabel = new Label("Turn Score");
    private final Label playerTotalScoreLabel = new Label("Total Score");
    private final Label computerTotalScoreLabel = new Label("Total Score");

    private final TextField playerTurnScoreTextField = new TextField();
    private final TextField playerTotalScoreTextField = new TextField();
    private final TextField computerTurnScoreTextField = new TextField();
    private final TextField computerTotalScoreTextField = new TextField();
    private final TextField statusTextField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        playerTurnScoreLabel.setFont(new Font("Calibri", 24));
        playerTurnScoreLabel.setTextFill(Color.web("#FFF"));

        computerTurnScoreLabel.setFont(new Font("Calibri", 24));
        computerTurnScoreLabel.setTextFill(Color.web("#FFF"));

        playerTotalScoreLabel.setFont(new Font("Calibri", 24));
        playerTotalScoreLabel.setTextFill(Color.web("#FFF"));

        computerTotalScoreLabel.setFont(new Font("Calibri", 24));
        computerTotalScoreLabel.setTextFill(Color.web("#FFF"));

        statusTextField.setFont(new Font("Calibri", 24));

        playerTurnScoreTextField.setFont(new Font("Calibri", 24));
        playerTotalScoreTextField.setFont(new Font("Calibri", 24));

        computerTurnScoreTextField.setFont(new Font("Calibri", 24));
        computerTotalScoreTextField.setFont(new Font("Calibri", 24));

        BackgroundSize backgroundSize = new BackgroundSize(1217, 812, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(2);
        grid.setVgap(2);
        for (int i = 0; i < 8; i++) {
            grid.getRowConstraints().add(new RowConstraints(100));
        }
        for (int i = 0; i < 7; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(170));
        }

        Dice dice = new Dice();

        grid.add(playerTurnScoreLabel, 0, 3, 1, 1);
        grid.add(playerTotalScoreLabel, 0, 4, 1, 1);
        grid.add(computerTurnScoreLabel, 4, 3, 1, 1);
        grid.add(computerTotalScoreLabel, 4, 4, 1, 1);
        grid.add(statusTextField, 1, 6, 5, 1);
        grid.add(playerTurnScoreTextField, 1, 3, 1, 1);
        grid.add(playerTotalScoreTextField, 1, 4, 1, 1);
        grid.add(computerTurnScoreTextField, 5, 3, 1, 1);
        grid.add(computerTotalScoreTextField, 5, 4, 1, 1);


        grid.setBackground(background);
        grid.setOnMouseClicked(e -> {
            if (e.getX() >= 480 && e.getX() <= 708 && e.getY() >= 515 && e.getY() <= 592) {
                dice.rollDice();
                Image dieImage1 = new Image("dice-" + dice.getDie1() + ".png");
                Image dieImage2 = new Image("dice-" + dice.getDie2() + ".png");
                ImageView i1 = new ImageView(dieImage1);
                ImageView i2 = new ImageView(dieImage2);
                removeNodeByRowColumnIndex(2, 2, grid);
                removeNodeByRowColumnIndex(2, 3, grid);
                grid.add(i1, 2, 2);
                grid.add(i2, 3, 2);

                if (myTurn) {
                    if (dice.getDie1() == turnOver || dice.getDie2() == turnOver) {
                        playerTotal = 0;
                        playerTurnTotal = 0;
                        System.out.println(playerTurnTotal);
                        playerTurnScoreTextField.setText(String.valueOf(playerTurnTotal));
                        System.out.println(playerTotal);
                        playerTotalScoreTextField.setText(String.valueOf(playerTotal));
                        System.out.println(computerTurnTotal);
                        computerTurnScoreTextField.setText(String.valueOf(computerTurnTotal));
                        System.out.println(computerTotal);
                        computerTotalScoreTextField.setText(String.valueOf(computerTotal));
                        System.out.println("You rolled 1. Your grand total is zeroed. Press roll again to continue.");
                        statusTextField.setText("You rolled 1. Your grand total is zeroed. Press roll again to continue.");
                        myTurn = false;

                    } else {
                        playerTurnTotal = dice.getDiceSum();
                        playerTotal = playerTotal + dice.getDiceSum();
                        System.out.println(playerTurnTotal);
                        playerTurnScoreTextField.setText(String.valueOf(playerTurnTotal));
                        System.out.println(playerTotal);
                        playerTotalScoreTextField.setText(String.valueOf(playerTotal));
                        System.out.println(computerTurnTotal);
                        computerTurnScoreTextField.setText(String.valueOf(computerTurnTotal));
                        System.out.println(computerTotal);
                        computerTotalScoreTextField.setText(String.valueOf(computerTotal));
                        if (playerTotal < winner) {
                            System.out.println("Your grand total is: " + playerTotal + ". Press roll again to continue.");
                            statusTextField.setText("Your grand total is: " + playerTotal + ". Press roll again to continue.");
                            myTurn = false;
                        } else {
                            System.out.println("Your grand total is: " + playerTotal + ". You win!");
                            statusTextField.setText("Your grand total is: " + playerTotal + ". You win!  Press roll again to play again.");
                            playerTotal = 0;
                            playerTurnTotal = 0;
                            computerTurnTotal = 0;
                            computerTotal = 0;
                            myTurn = true;
                        }
                    }

                } else {
                    if (dice.getDie1() == turnOver || dice.getDie2() == turnOver) {
                        computerTotal = 0;
                        computerTurnTotal = 0;
                        System.out.println(computerTurnTotal);
                        computerTurnScoreTextField.setText(String.valueOf(computerTurnTotal));
                        System.out.println(computerTotal);
                        computerTotalScoreTextField.setText(String.valueOf(computerTotal));
                        System.out.println("Computer rolled 1. It's grand total is zeroed. Press roll again to continue");
                        statusTextField.setText("Computer rolled 1. It's grand total is zeroed. Press roll again to continue.");
                        myTurn = true;
                    } else {
                        computerTurnTotal = dice.getDiceSum();
                        computerTotal = computerTotal + dice.getDiceSum();
                        System.out.println(playerTurnTotal);
                        playerTurnScoreTextField.setText(String.valueOf(playerTurnTotal));
                        System.out.println(playerTotal);
                        playerTotalScoreTextField.setText(String.valueOf(playerTotal));
                        System.out.println(computerTurnTotal);
                        computerTurnScoreTextField.setText(String.valueOf(computerTurnTotal));
                        System.out.println(computerTotal);
                        computerTotalScoreTextField.setText(String.valueOf(computerTotal));
                        if (computerTotal < winner) {
                            System.out.println("Computer grand total is: " + computerTotal + ". Press roll again to continue.");
                            statusTextField.setText("Computer grand total is: " + computerTotal + ". Press roll again to continue.");
                            myTurn = true;
                        } else {
                            System.out.println("Computer grand total is: " + computerTotal + " Computer wins!");
                            statusTextField.setText("Computer grand total is: " + computerTotal + ". Computer wins! Press roll again to play again.");
                            playerTotal = 0;
                            playerTurnTotal = 0;
                            computerTurnTotal = 0;
                            computerTotal = 0;
                            myTurn = false;
                        }
                    }
                }
            }
        });

        Scene scene = new Scene(grid, 1217, 812, Color.WHITESMOKE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void removeNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {

        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            if (node instanceof ImageView && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                ImageView imageView = (ImageView) node; // use what you want to remove
                gridPane.getChildren().remove(imageView);
                break;
            }
        }
    }
}


