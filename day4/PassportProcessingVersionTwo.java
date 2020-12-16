package day4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ReadFileClass.ReadFileClass;

public class PassportProcessingVersionTwo {
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
        int totalfields = list.length - 1;
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
            listOfAtts.remove(optionalAttr);
        }

        for (int i = 0; i < listOfAtts.size(); i++) {
            if (map.containsKey(listOfAtts.get(i))) {
                totalfields -= 1;
            }

        }
        if (totalfields == 0) {
            if (isCredentialsValid(map)) {
                System.out.println("This password is valid\n");
                return true;
            }
        }

        System.out.println("This password is not valid\n");
        return false;
    }

    private boolean isCredentialsValid(HashMap<String, String> map) {
        String[] list = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid" };
        String optionalAttr = "cid";
        ArrayList<String> listOfAtts = new ArrayList<String>();
        for (int i = 0; i < list.length; i++) {
            listOfAtts.add(list[i]);
        }

        if (map.containsKey(optionalAttr)) {
            listOfAtts.remove(optionalAttr);
        } else {
            listOfAtts.remove(optionalAttr);
        }

        for (int i = 0; i < listOfAtts.size(); i++) {
            if (conditionalFunctions(listOfAtts.get(i), map.get(listOfAtts.get(i)))) {
                System.out.println("Attribute " + listOfAtts.get(i) + " is valid.");
            } else {
                System.out.println("Attribute " + listOfAtts.get(i) + " is not valid.");
                return false;
            }
        }
        return true;
    }

    private boolean conditionalFunctions(String param, String mapValue) {
        // System.out.println("Passing in: " + param);
        switch (param) {
            case "byr":
                if (mapValue.length() == 4) {
                    int year = Integer.parseInt(mapValue);
                    if (year >= 1920 && year <= 2002) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case "iyr":
                if (mapValue.length() == 4) {
                    int year = Integer.parseInt(mapValue);
                    if (year >= 2010 && year <= 2020) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case "eyr":
                if (mapValue.length() == 4) {
                    int year = Integer.parseInt(mapValue);
                    if (year >= 2020 && year <= 2030) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case "hgt":
                if (mapValue.contains("cm") || mapValue.contains("in")) {
                    if (mapValue.contains("cm")) {
                        String heightString = mapValue.substring(0, mapValue.length() - 2);
                        int height = Integer.parseInt(heightString);
                        if (height >= 150 && height <= 193) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        String heightString = mapValue.substring(0, mapValue.length() - 2);
                        int height = Integer.parseInt(heightString);
                        if (height >= 59 && height <= 76) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            case "hcl":
                char alphabet[] = { 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                        'x', 'y', 'z' };
                if (mapValue.startsWith("#") && mapValue.length() == 7) {
                    for (char c : alphabet) {
                        if (!(mapValue.indexOf(c) == -1)) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            case "ecl":
                if (mapValue.equals("amb") || mapValue.equals("blu") || mapValue.equals("brn") || mapValue.equals("gry")
                        || mapValue.equals("grn") || mapValue.equals("hzl") || mapValue.equals("oth")) {
                    return true;
                } else {
                    return false;
                }
            case "pid":
                if (mapValue.length() == 9) {
                    return true;
                } else {
                    return false;
                }
            default:
                System.out.println("no match");
                return false;
        }
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
