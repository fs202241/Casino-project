package casino;

import java.util.*;
import java.io.*;
import casino.*;

public class Casino {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        files Files = new files();
        files.readFile();
        boolean chosen = false;
        while (chosen==false){
        System.out.println("Welcome to the casino!");
        System.out.println("What game would you like to play? \n"
                + " 0: Exit the casino \n"
                + " 1: Blackjack \n"
                + " 2: Higher or lower \n"
                + " 3: Roulette");

        int gameChoice = input.nextInt();
        if ((gameChoice<0)&&(gameChoice>3)){
            System.out.println("You must choose one of the options.");
        }
        switch (gameChoice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("You chose blackjack.");
                blackjack Blackjack = new blackjack();
                blackjack.Main();
                break;
            case 2:
                System.out.println("You chose higher or lower");
                HigherOrLower higherorlower = new HigherOrLower();
                HigherOrLower.main();
                break;
            case 3:
                System.out.println("You chose roulette");
                roulette Roulette = new roulette();
                roulette.main();
                break;
        }
        } 
    }
}

