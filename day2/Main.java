package day2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("day2/data.txt");

        PasswordChecker psCheck = new PasswordChecker();
        psCheck.displayResults(file);

        PasswordCheckerVersionTwo psCheckTwo = new PasswordCheckerVersionTwo();
        psCheckTwo.displayResults(file);

    }
}