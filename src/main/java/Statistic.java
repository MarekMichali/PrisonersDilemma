import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Statistic {
    private String fileName = "logs.txt";
    private int populationCount;
    private int interrogationCount;

    public List<Integer> getMeans() {
        return means;
    }

    private List<Integer> means = new ArrayList<>();
    Statistic(String fileName, int populationCount, int interrogationCount){
        this.fileName = fileName;
        this.populationCount = populationCount;
        this.interrogationCount = interrogationCount;
    }
    void generateStatics() throws FileNotFoundException {
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        int i = 0;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if(i % populationCount + 2 == 0){
                means.add(Integer.parseInt(line));
            }
            i++;
            //System.out.println(line);
        }
    }
}
