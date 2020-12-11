package day3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class TreeEncounterVersionTwo {

    private ArrayList<Long> countTrees(List<ArrayList<Character>> dataList, int[] xSlopes, int[] ySlopes) {
        System.out.println("Number of rows: " + dataList.size());
        System.out.println("Number of columns: " + dataList.get(1).size());
        ArrayList<Long> countArray = new ArrayList<>();

        for (int z = 0; z < xSlopes.length; z++) {
            long count = 0;
            int x = xSlopes[z];
            int y = ySlopes[z];
            while (y < dataList.size()) {
                while (!(x >= dataList.get(0).size())) {
                    System.out.println("Current symbol is " + dataList.get(y).get(x));
                    if (dataList.get(y).get(x).equals('#')) {
                        count++;
                        System.out.println("Adding to count cuz hashtag was found " + count);
                    }
                    System.out.println("Before xSlope add: " + x);
                    System.out.println("Before ySlope add: " + y);
                    x = x + xSlopes[z];
                    y = y + ySlopes[z];
                    System.out.println("After xSlope add: " + x);
                    System.out.println("After ySlope add: " + y);

                    if (y >= dataList.size()) {
                        countArray.add(count);
                        System.out.println("We are about to break");
                        break;
                    }

                }
                x = x - dataList.get(0).size();
            }
        }
        return countArray;
    }

    public void displayResults(File textFile, int[] x, int[] y) throws IOException {
        long count = 1;
        ArrayList<Long> countArray;
        ReadFileClass fileReader = new ReadFileClass(textFile);
        countArray = countTrees(fileReader.get2DCharacterArray(), x, y);
        for (long i : countArray) {
            System.out.println(i);
            count = count * i;
        }
        System.out.println("There are a total of " + count + " trees that are in the way.");
    }
}