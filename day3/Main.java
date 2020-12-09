package day3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("day3/data.txt");

        TreeEncounter checkPath = new TreeEncounter();
        checkPath.displayResults(file);

        // TreeEncounterVersionTwo checkPathTwo = new TreeEncounterVersionTwo();
        // checkPathTwo.displayResults(file);

    }
}