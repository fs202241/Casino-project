package casino;

import java.util.Random;
import java.util.Scanner;
import casino.*;

public class HigherOrLower {

    static Scanner input = new Scanner(System.in);
    static int score = 0;
    static int cardNum = 0;
    static int secondCard = 0;
    static boolean playagain = true;
    static int userMoney;

    public static void main() {
        userMoney = files.userMoney;
        System.out.println("Welcome to higher or lower. You will be given a card, and you must guess if the next card will be higher, lower, or equal.");
        System.out.println("Depending on what kind of card you are given, you can gain more points. If you guess correctly, you will also get points.");
        while (playagain == true) {
            getCards();
            getSecondCard();
            getGuess();
            playAgain();
        }
    }

    public static void getCards() {
        System.out.println("Assigning first card...");
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            cardNum = random.nextInt((52 - 1) + 1) + 1;
            if ((cardNum == 11)||(cardNum == 22)||(cardNum == 33)||(cardNum == 44)) {
                System.out.println("You got a jack! This takes away 20 points!");
                score = score - 20;
            } else if ((cardNum == 12)||(cardNum == 24)||(cardNum == 36)||(cardNum == 48)) {
                System.out.println("You got a queen! This adds 2 points!");
                score = score + 2;
            } else if ((cardNum == 13)||(cardNum == 26)||(cardNum == 39)||(cardNum == 52)) {
                System.out.println("You got a king! This doubles your score!");
                score = score * 2;
            }
            System.out.println("Your card number is " + cardNum);
        }
    }

    public static void getSecondCard() {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            secondCard = random.nextInt((52 - 1) + 1) + 1;
        }

    }

    public static void getGuess() {
        String guess;
        System.out.println("Do you think the next card will be higher or lower? H/L/E");
        guess = input.next();
        if (guess.equals("H")) {
            if (secondCard > cardNum) {
                System.out.println("You got it right!");
                score = score + 5;
                playagain = false;
            } else if (secondCard == cardNum) {
                score = score - 5;
                System.out.println("The cards are equal. You lose!");
                playagain = false;
            } else if (secondCard < cardNum) {
                score = score - 5;
                System.out.println("The card was lower. You lose!");
                playagain = false;
            }
        } else if (guess.equals("L")) {
            if (secondCard > cardNum) {
                System.out.println("The card was lower. You lose!");
                score = score - 5;
                playagain = false;
            } else if (secondCard == cardNum) {
                score = score - 5;
                System.out.println("The cards are equal. You lose!");
                playagain = false;
            } else if (secondCard < cardNum) {
                score = score + 5;
                System.out.println("You got it right!");
                playagain = false;
            }
        } else if (guess.equals("E")) {
            if (secondCard > cardNum) {
                System.out.println("The card was lower. You lose!");
                score = score - 5;
                playagain = false;
            } else if (secondCard == cardNum) {
                score = score + 5;
                System.out.println("You got it right!");
                playagain = false;
            } else if (secondCard < cardNum) {
                score = score - 5;
                System.out.println("The card was higher. You lose!!");
                playagain = false;
            }
        }
    }

    public static void playAgain() {
        System.out.println("Play again? Y/N");
        String play = input.next();
        if (play.equals("Y")) {
            playagain = true;
        } else if (play.equals("N")) {
            System.out.println("Your score is " + score);
            userMoney = score*15;
            files.writeFile(userMoney);
            System.out.println("This is worth £" + score * 15);
            System.out.println("You have £"+userMoney);
            String[] args = new String[]{" "};
            Casino.main(args);
        }
    }
}
