package day3.ModifiedCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class TreeEncounterModified {
    List<String> mapData = new ArrayList<>();

    private int slope(int xSlope, int ySlope) {
        int numOfTrees = 0;
        int x = xSlope;
        int y = ySlope;

        while (y < mapData.size()) {
            if (mapData.get(y).charAt(x) == '#') {
                numOfTrees++;
            }

            x = x + xSlope;

            if (x >= mapData.get(0).length()) {
                x = x - mapData.get(0).length();
            }
            y = y + ySlope;
        }

        return numOfTrees;
    }

    public void displayResults(File text, int xComp, int yComp) throws IOException {
        ReadFileClass inputData = new ReadFileClass(text);
        mapData = inputData.getStringArray();
        int totalCountOfTrees = slope(xComp, yComp);
        System.out.println("The total number of trees encountered was: " + totalCountOfTrees);
    }
}