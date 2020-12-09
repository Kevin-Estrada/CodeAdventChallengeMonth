package ReadFileClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileClass {
    private Scanner scnr;

    public ReadFileClass(File text) throws FileNotFoundException {
        // Creating Scanner instnace to read File in Java
        scnr = new Scanner(text);
    }

    private ArrayList<Integer> readNumbersIntoArray() {
        ArrayList<Integer> listOfNums = new ArrayList<>();
        // Reading each line of file using Scanner class
        while (scnr.hasNextInt()) {
            int num = scnr.nextInt();
            listOfNums.add(num);
        }
        return listOfNums;
    }

    private ArrayList<String> readStringsIntoArray() {
        ArrayList<String> listOfStrings = new ArrayList<>();
        // Reading each line of file using Scanner class
        while (scnr.hasNextLine()) {
            String word = scnr.nextLine();
            listOfStrings.add(word);
        }
        return listOfStrings;
    }

    private ArrayList<ArrayList<String>> read2DStringArray() {
        int row = 0;
        ArrayList<ArrayList<String>> string2DMap = new ArrayList<>();
        while (scnr.hasNextLine()) {
            String word = scnr.nextLine();
            String[] values = word.split(" ");
            // This creates the row
            string2DMap.add(new ArrayList<>());
            for (int i = 0; i < values.length; i++) {
                string2DMap.get(row).add(i, values[i]);
            }
        }
        return string2DMap;
    }

    private ArrayList<ArrayList<Character>> read2DCharacterArray() {
        int row = 0;
        int index = 0;
        ArrayList<ArrayList<Character>> character2DMap = new ArrayList<>();
        while (scnr.hasNextLine()) {
            String word = scnr.nextLine();
            char[] charArray = word.toCharArray();
            // This creates the row
            character2DMap.add(index, new ArrayList<>());
            index++;
            for (int i = 0; i < charArray.length; i++) {
                character2DMap.get(row).add(i, charArray[i]);
            }
            row++;
        }
        return character2DMap;
    }

    public List<Integer> getNumArray() {
        return readNumbersIntoArray();
    }

    public List<String> getStringArray() {
        return readStringsIntoArray();
    }

    public List<ArrayList<String>> get2DStringArray() {
        return read2DStringArray();
    }

    public List<ArrayList<Character>> get2DCharacterArray() {
        return read2DCharacterArray();
    }

}
