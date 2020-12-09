package day2;

import java.io.*;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class PasswordChecker {

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

            char[] charArray = getCharArray(values[2]);

            if (isPasswordValid(minNum, maxNum, letter, charArray)) {
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

    private static char[] getCharArray(String str) {
        return str.toCharArray();
    }

    private static boolean isPasswordValid(int minNum, int maxNum, char letter, char[] charArray) {
        int numOfOccur = 0;
        for (char s : charArray) {
            if (letter == s) {
                numOfOccur++;
            }
        }

        if (minNum <= numOfOccur && maxNum >= numOfOccur) {
            return true;
        }
        return false;
    }

    public void displayResults(File textFile) throws IOException {
        int count = returnResult(textFile);
        System.out.println("There are a total of " + count + " valid passwords that meet the policies.");
    }
}