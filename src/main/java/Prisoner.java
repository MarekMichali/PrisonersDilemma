import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prisoner {
    private List<Integer> lastThreeMoves = new ArrayList<>();
    private Random random = new Random();
    private BitChromosome strategy;
    private int score;


    Prisoner(BitChromosome _strategy){
        score = 0;
        strategy = _strategy;
        for(int i = 0; i < 3; i++){
            lastThreeMoves.add(random.nextInt(3));
        }
    }



    List<Integer> getLastThreeMoves(){
        return lastThreeMoves;
    }

    void setLastMove(int move){
        lastThreeMoves.add(move);
        lastThreeMoves.remove(3);
    }
}
