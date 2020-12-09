package day3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class TreeEncounter {

    private int countTrees(List<ArrayList<Character>> dataList) {
        // System.out.println("Number of rows: " + dataList.size());
        // System.out.println("Number of columns: " + dataList.get(1).size());
        int count = 0;
        int jIndex = 3;
        int iIndex = 1;
        for (int i = 1; i < dataList.size(); i++) {
            while (!(jIndex >= dataList.get(iIndex).size())) {
                // System.out.println("Before adding to iIndex: " + iIndex);
                // System.out.println("Before adding to jIndex: " + jIndex);
                // System.out.println("-----------------------------------");

                if (dataList.get(iIndex).get(jIndex).equals('#')) {
                    count++;
                    // System.out.println("I am inside this loop for count: " + count);
                }
                jIndex += 3;
                iIndex += 1;

                // System.out.println("After adding to iIndex: " + iIndex);
                // System.out.println("After adding to jIndex: " + jIndex);
                // System.out.println("-----------------------------------");

                if (iIndex == dataList.size()) {
                    return count;
                }
            }
            jIndex = jIndex - dataList.get(iIndex).size();
            // System.out.println("I am outside while loop wtih iIndex: " + iIndex);
            // System.out.println("I am outside while loop wtih jIndex: " + jIndex);
            // System.out.println("-----------------------------------");
        }
        return count;
    }

    public void displayResults(File textFile) throws IOException {
        int count = 0;
        ReadFileClass fileReader = new ReadFileClass(textFile);
        count = countTrees(fileReader.get2DCharacterArray());
        System.out.println("There are a total of " + count + " trees that are in the way.");
    }
}