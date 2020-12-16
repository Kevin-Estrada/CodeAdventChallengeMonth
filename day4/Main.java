package day4;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("day4/data.txt");

        PassportProcessing passportPartOne = new PassportProcessing();
        passportPartOne.displayResult(file);

        PassportProcessingVersionTwo passportPartTwo = new PassportProcessingVersionTwo();
        passportPartTwo.displayResult(file);

    }
}
