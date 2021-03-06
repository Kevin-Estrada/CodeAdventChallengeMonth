package day2;

import java.io.*;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class PasswordCheckerVersionTwo {

    private static int returnResult(File textFile) throws IOException {
        int count = 0;
        ReadFileClass fileReader = new ReadFileClass(textFile);
        List<String> listOfStrings = fileReader.getStringArray();
        for (String st : listOfStrings) {
            String[] values = st.split(" ");

            int[] minAndMaxValues = getMinMaxNum(values[0]);
            int minNum = minAndMaxValues[0];
            int maxNum = minAndMaxValues[1];

            char letter = getChar(values[1]);

            String password = values[2];

            if (isPasswordValid(minNum, maxNum, letter, password)) {
                count++;
            }
        }

        return count;
    }

    private static char getChar(String str) {
        String[] stringArray = str.split(":");
        return stringArray[0].charAt(0);
    }

    private static int[] getMinMaxNum(String str) {
        String[] stringArray = str.split("-");
        int[] minMaxArray = new int[stringArray.length];
        for (int i = 0; i < minMaxArray.length; i++) {
            minMaxArray[i] = Integer.parseInt(stringArray[i]);
        }
        return minMaxArray;
    }

    private static boolean isPasswordValid(int minNum, int maxNum, char letter, String str) {
        int count = 0;

        if (str.charAt(minNum - 1) == letter) {
            count++;
        }
        if (str.charAt(maxNum - 1) == letter) {
            count++;
        }
        if (count == 2 || count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void displayResults(File textFile) throws IOException {
        int count = returnResult(textFile);
        System.out.println("There are a total of " + count + " valid passwords that meet the policies.");
    }
}