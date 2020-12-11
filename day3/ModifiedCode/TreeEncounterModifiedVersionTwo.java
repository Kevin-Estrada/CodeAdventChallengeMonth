package day3.ModifiedCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class TreeEncounterModifiedVersionTwo {
    List<String> mapData = new ArrayList<>();
    long totalNumOfTrees = 1;

    private long slope(int[] xSlope, int[] ySlope) {
        ArrayList<Long> numOfTreesArray = new ArrayList<>();
        for (int z = 0; z < xSlope.length; z++) {
            long numOfTrees = 0;
            int x = xSlope[z];
            int y = ySlope[z];
            while (y < mapData.size()) {
                if (mapData.get(y).charAt(x) == '#') {
                    numOfTrees++;
                }

                x = x + xSlope[z];

                if (x >= mapData.get(0).length()) {
                    x = x - mapData.get(0).length();
                }
                y = y + ySlope[z];
            }
            // System.out.println(
            // "Number of trees after slopes x:" + xSlope[z] + " and y:" + ySlope[z] + " is
            // " + numOfTrees);
            numOfTreesArray.add(numOfTrees);
        }
        for (long i : numOfTreesArray) {
            totalNumOfTrees = i * totalNumOfTrees;
        }
        return totalNumOfTrees;
    }

    public void displayResults(File text, int[] xComp, int[] yComp) throws IOException {
        ReadFileClass inputData = new ReadFileClass(text);
        mapData = inputData.getStringArray();
        long totalCountOfTrees = slope(xComp, yComp);
        System.out.println("The total number of trees encountered was: " + totalCountOfTrees);
    }
}
