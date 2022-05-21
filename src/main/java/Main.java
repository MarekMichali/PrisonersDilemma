
//mozliwosci kazdego rouchu 00-01-10-11
//3 ostatnie ruchy xx-xx-xx czyli 4*4*4=64 mozliwosci
//3 pierwsze ruchy generowac losowo

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter population count: ");
        int count = in.nextInt();
        System.out.println("Enter how many times should an interrogation of all prisoners take place: ");
        int interrogationCount = in.nextInt();
        System.out.println("Enter how many times should an interrogation of two selected prisoners take place: ");
        int interrogationCountPrisoner = in.nextInt();
        System.out.println("Before");
        int mean = 0;
        //int count = 50;
       // int interrogationCount = 2000;
        Prison prison = new Prison(count, interrogationCountPrisoner);
        File file = new File("logs.txt");
        file.delete();
        BufferedWriter logs = new BufferedWriter(new FileWriter("logs.txt", true));
        logs.write("start \n");
        for(int i = 0; i < interrogationCount; i++){;
            prison.interrogation();
            EvolutionEngine evolutionEngine = new EvolutionEngine(prison);
            evolutionEngine.calculateMean();
            mean = evolutionEngine.getMean();
            logs.append(Integer.toString(mean) + '\n');
            for(int j = 0; j < count; j++){
                for(int k = 0; k < 64; k++){
                    logs.append(prison.getPrisoners().get(j).getStrategy().get(k).toString());
                }
                logs.append('\n');
            }
            logs.append('\n');
            logs.append('\n');
            System.out.println(mean);
            evolutionEngine.reproduce();
        }
        logs.close();
        System.out.println(mean);

    }
}