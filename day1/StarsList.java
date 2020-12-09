package day1;

import java.io.*;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class StarsList {

    private static int returnResult(List<Integer> listNums) {
        int result = 0;
        int firstNum = 0;
        int secondNum = 0;
        for (int i = 0; i < listNums.size(); i++) {
            for (int j = 1; j < listNums.size(); j++) {
                firstNum = listNums.get(i);
                secondNum = listNums.get(j);
                if ((firstNum + secondNum) == 2020) {
                    System.out.println("The first number is: " + firstNum);
                    System.out.println("The second number is: " + secondNum);
                    return firstNum * secondNum;
                }
            }
        }

        return result;
    }

    public void displayResult(File file) throws IOException {
        final long startTime = System.currentTimeMillis();
        int result = 0;
        ReadFileClass fileReader = new ReadFileClass(file);
        List<Integer> listOfNums = fileReader.getNumArray();
        result = returnResult(listOfNums);
        if (result == 0) {
            System.out.println("Result not found!");
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));
        } else {
            System.out.println("The result of the 2 numbers is: " + result);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));
        }
    }

}
