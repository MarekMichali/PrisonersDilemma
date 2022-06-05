import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prisoner {
    private List<Integer> lastThreeMoves = new ArrayList<>();
    private Random random = new Random();
    private List<Integer> strategy = new ArrayList<>();
    private int score = 0;


    Prisoner(){
        score = 0;
       // this.strategy = strategy;
        for(int i = 0; i < 3; i++){
          //  lastThreeMoves.add(random.nextInt(4));
            lastThreeMoves.add(-1);
        }
        for(int i = 0; i < 85; i++){
            strategy.add(random.nextInt(2));
        }
       // strategy.set(1, 1);
    }
    public int getScore() {
        return score;
    }

    List<Integer> getLastThreeMoves(){
        return lastThreeMoves;
    }

    void setLastMove(int move){
        lastThreeMoves.add(0, move);
        lastThreeMoves.remove(3);
    }

    List<Integer> getStrategy(){
        return strategy;
    }

    void setMove(int index, int move){
        strategy.set(index, move);
    }

    void changeScore(int points){
        score+=points;
    }
}
