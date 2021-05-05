
package casino;

import java.util.*;
import casino.*;




public class roulette {
    
    static int userMoney;
    static int globalBet;
    static boolean playagain = true;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Integer> betNums = new ArrayList<>();
    
    
    public static void main(){
        userMoney = files.userMoney;
        while (playagain == true){
        System.out.println("Welcome to roulette! Bet on a number or group of numbers and collect your winnings if you've guessed the right number!\n"
                + "Your bet is split between the amount of numbers you bet on, so be careful.");
        getBet();
        checkWin();
        playAgain();
        }
    }
    public static void getBet(){
        System.out.println("You have £"+userMoney);
        System.out.println("Place your bet.");
        globalBet = input.nextInt();
        userMoney = userMoney - globalBet;
        boolean done = false;
        while (done == false){
        System.out.println("What numbers would you like to bet on? They must be between 0 and 36. Type 'Done' when done.");
        String bet = input.next();
            if (bet.equals("Done")){
                done = true;
                Collections.sort(betNums);
                System.out.println("You bet on: "+betNums.toString());
            }else{
                try{
                int betInt = Integer.parseInt(bet);
                if ((betInt>36)||(betInt<0)){
                    System.out.println("Those numbers were out of range. Try again.");
                } else {
                    betNums.add(betInt);
                }
                Set<Integer> set = new HashSet<Integer>(betNums);
                    if (set.size() < betNums.size()) {
                        System.out.println("You cannot bet on a number twice. The duplicate bet has been removed");
                        int index = betNums.size() - 1;
                        betNums.remove(index);
                    }
            }catch (NumberFormatException e) {
                    System.out.println("Error"+e);
                    System.out.println("You must bet on a number.");
        }}
        

    }
 
    
    
    }
    public static void checkWin(){
        System.out.println("Spinning the wheel...");
        boolean win = false;
        Random random = new Random();
        int randy = random.nextInt((36 - 1) + 1) + 1;
        for (int i = 0; i < betNums.size(); i++) {
            if (randy == betNums.get(i)){
                win = true;     
        }
        }
        if (win==true){
            System.out.println("You win!");
            userMoney = userMoney+(globalBet/betNums.size());
            betNums.clear();
            files.writeFile(userMoney);
        }else
            System.out.println("You lost!");
        betNums.clear();
        files.writeFile(userMoney);
    }
        public static void playAgain() {
        System.out.println("Play again? Y/N");
        String play = input.next();
        if (play.equals("Y")) {
        } else if (play.equals("N")) {
            String[] args = new String[]{" "};
            Casino.main(args);
        }
    }
}