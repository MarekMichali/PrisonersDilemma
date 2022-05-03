import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Statistic {
    private String fileName = "logs.txt";
    Statistic(String fileName){
        this.fileName = fileName;
    }
    void generateStatics() throws FileNotFoundException {
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
    }
}
