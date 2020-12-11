package day3;

import java.io.*;

import day3.ModifiedCode.TreeEncounterModified;
import day3.ModifiedCode.TreeEncounterModifiedVersionTwo;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("day3/data.txt");

        TreeEncounter checkPathOne = new TreeEncounter();
        checkPathOne.displayResults(file);

        int[] x = { 1, 3, 5, 7, 1 };
        int[] y = { 1, 1, 1, 1, 2 };
        TreeEncounterVersionTwo checkPathTwo = new TreeEncounterVersionTwo();
        checkPathTwo.displayResults(file, x, y);

        TreeEncounterModified checkPathMOne = new TreeEncounterModified();
        checkPathMOne.displayResults(file, 1, 2);

        int[] xM = { 1, 3, 5, 7, 1 };
        int[] yM = { 1, 1, 1, 1, 2 };
        TreeEncounterModifiedVersionTwo checkPathMTwo = new TreeEncounterModifiedVersionTwo();
        checkPathMTwo.displayResults(file, xM, yM);

    }
}