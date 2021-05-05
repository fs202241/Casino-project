package casino;

import java.io.*;
import java.util.*;
import casino.*;

public class files {

    public static String folderDirectory = System.getProperty("user.dir") + "\\money.txt";
    public static ArrayList<String> textItems = new ArrayList<>();
    static int userMoney;
    
    public static void main(){

    }

    public static void writeFile(int money) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(money);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readFile() {
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((inputLine = read.readLine()) != null) {
                textItems.add(inputLine);
                String userMoney1 = textItems.get(textItems.size() - 1);
                userMoney = Integer.parseInt(userMoney1);
            }

            read.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        
    }

}
