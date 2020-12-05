import java.io.*;

public class StarsList {

    private static int buildSizeArray(File textFile) throws IOException {
        int size = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            String st;
            while ((st = br.readLine()) != null) {
                // System.out.println(st);
                size++;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        return size;
    }

    private static int[] buildArray(File textFile) throws IOException {
        int count = 0;
        int size = buildSizeArray(textFile);
        int[] arrayList = new int[size];

        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            String st;
            while ((st = br.readLine()) != null) {
                int inum = Integer.parseInt(st);
                // System.out.println(inum);
                arrayList[count] = inum;
                // System.out.println("arrayList[" + count + "]: " + arrayList[count]);
                count++;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        return arrayList;
    }

    private static int returnResult(int[] listNums) {
        int result = 0;
        int firstNum = 0;
        int secondNum = 0;
        for (int i = 0; i < listNums.length; i++) {
            for (int j = 1; j < listNums.length; j++) {
                firstNum = listNums[i];
                // System.out.println("First Num: " + firstNum);
                secondNum = listNums[j];
                // System.out.println("Second Num: " + secondNum);
                if ((firstNum + secondNum) == 2020) {
                    System.out.println("The first number is: " + firstNum);
                    System.out.println("The second number is: " + secondNum);
                    return result = firstNum * secondNum;
                }
            }
        }

        return result;
    }

    public void displayResult(File file) throws IOException {
        final long startTime = System.currentTimeMillis();
        int result = 0;
        int[] listOfNums = buildArray(file);
        result = returnResult(listOfNums);
        if (result == 0) {
            System.out.println("Result not found!");
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));
        } else {
            System.out.println("The result of the 2 numbers is: " + result);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));
        }
    }

}
