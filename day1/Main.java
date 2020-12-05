import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("./data.txt");
        StarsList twoNums = new StarsList();
        StarsListThree threeNums = new StarsListThree();

        twoNums.displayResult(file);
        threeNums.displayResult(file);
    }
}
