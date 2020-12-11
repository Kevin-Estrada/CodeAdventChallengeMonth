package day4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class PassportProcessing {
    ArrayList<HashMap<String, String>> listOfHashMaps = new ArrayList<HashMap<String, String>>();

    private int validPasswords(List<String> dataInput) {
        int sumOfValidPasswords = 0;
        listOfHashMaps = buildListOfMaps(dataInput);
        for (HashMap<String, String> map : listOfHashMaps) {
            if (isPasswordValid(map)) {
                sumOfValidPasswords++;
            }
        }

        return sumOfValidPasswords;
    }

    private boolean isPasswordValid(HashMap<String, String> map) {
        System.out.println("I made it into isPasswordValid method");
        String[] list = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid" };
        int totalfields = list.length;
        String optionalAttr = "cid";
        ArrayList<String> listOfAtts = new ArrayList<String>();
        for (int i = 0; i < list.length; i++) {
            listOfAtts.add(list[i]);
        }

        if (map.containsKey(optionalAttr)) {
            System.out.println("The cid is avaliable");
            listOfAtts.remove(optionalAttr);
        } else {
            System.out.println("The cid is not avaliable");
        }

        for (int i = 0; i < listOfAtts.size(); i++) {
            if (map.containsKey(listOfAtts.get(i))) {
                totalfields -= 1;
            }

        }

        if (totalfields == 0 || totalfields == 1) {
            System.out.println("This password is valid\n");
            return true;
        }

        System.out.println("This password is not valid\n");
        return false;
    }

    private HashMap<String, String> buildHashMap(String text) {
        HashMap<String, String> map = new HashMap<String, String>();
        String[] listOfAttributes = text.split(" ");
        for (int i = 0; i < listOfAttributes.length; i++) {
            String[] listOfkeys = listOfAttributes[i].split(":");
            map.put(listOfkeys[0], listOfkeys[1]);
        }

        System.out.println(map);
        System.out.println();
        return map;
    }

    private ArrayList<HashMap<String, String>> buildListOfMaps(List<String> dataList) {
        ArrayList<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        String text = "";
        for (String st : dataList) {
            if (!st.isEmpty()) {
                text = text + st + " ";
                // System.out.println("Line of text is: " + text);
            } else {
                listMap.add(buildHashMap(text));
                text = "";
            }
        }

        listMap.add(buildHashMap(text));

        return listMap;

    }

    public void displayResult(File file) throws IOException {
        ReadFileClass fileReader = new ReadFileClass(file);
        List<String> dataInput = fileReader.getStringArray();
        int numOfValidPasswords = validPasswords(dataInput);
        System.out.println("The total number of valid passwords is: " + numOfValidPasswords);
    }

}
