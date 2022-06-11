package logic;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvolutionEngine {
    private Prison prison;
    int chromoCount = 85;

    public int getMean() {
        return mean;
    }
    private int mutationRation = 100000;
    private int mean;
    int standardDeviation = 0;
    private Random random = new Random();
    private List<Prisoner> meanPlus = new ArrayList<>();
    private List<Prisoner> meanEqual = new ArrayList<>();
    private List<Prisoner> meanMinus = new ArrayList<>();

    public EvolutionEngine(Prison prison){
        this.prison=prison;
    }

    public void calculateMean(){
        int prisonCount = prison.getPrisonersCount();
        this.mean = prison.getPrisonScore() / prisonCount;
        for(int i = 0; i < prisonCount; i++){
            standardDeviation += (int) Math.pow(prison.getPrisoners().get(i).getScore() - mean, 2);
        }
        standardDeviation = standardDeviation / prisonCount;
        standardDeviation = (int) Math.sqrt(standardDeviation);

    }

    public void reproduce(){
        for(int i = 0; i < prison.getPrisonersCount(); i++){
            if(prison.getPrisoners().get(i).getScore() >= mean + standardDeviation){
                meanPlus.add(prison.getPrisoners().get(i));
            } else if (prison.getPrisoners().get(i).getScore() < mean - standardDeviation) {
                meanMinus.add(prison.getPrisoners().get(i));
            } else {
                meanEqual.add(prison.getPrisoners().get(i));
            }
        }

        //standard
        if(meanEqual.size() % 2 == 0){
            for(int i = 0; i < meanEqual.size(); i+=2) {
                int cross = random.nextInt(chromoCount);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanEqual.get(i).getStrategy());
                for (int j = cross; j < chromoCount; j++) {
                    if(random.nextInt(mutationRation) == 1){
                        if(meanEqual.get(i + 1).getStrategy().get(j) == 0){
                            meanEqual.get(i).setMove(j, 1);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanEqual.get(i).setMove(j, 0);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanEqual.get(i).setMove(j, meanEqual.get(i + 1).getStrategy().get(j));
                        meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }

                }
            }
        } else{
            for(int i = 1; i < meanEqual.size(); i+=2) {
                int cross = random.nextInt(chromoCount);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanEqual.get(i).getStrategy());
                for (int j = cross; j < chromoCount; j++) {
                    if(random.nextInt(mutationRation) == 1){
                        if(meanEqual.get(i + 1).getStrategy().get(j) == 0){
                            meanEqual.get(i).setMove(j, 1);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanEqual.get(i).setMove(j, 0);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanEqual.get(i).setMove(j, meanEqual.get(i + 1).getStrategy().get(j));
                        meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }
                }
            }
        }

        //wors porpawic
       /* int max = 0;
        int lastMax = 0;
        for(int i = 0; i < meanMinus.size(); i+=2) {

            Prisoner moved = new Prisoner();
            for(int j = 0; j < meanPlus.size(); j++){
                if(meanPlus.get(j).getScore() > max && meanPlus.get(j).getScore() != lastMax){
                    max = meanPlus.get(j).getScore();
                }
            }
            for(int j = 0; j < meanPlus.size(); j++){
                if(meanPlus.get(j).getScore() == max){
                    for (int k = 0; k < 64; k++) {
                        meanMinus.get(i).setMove(k, meanPlus.get(j).getStrategy().get(k));
                    }
                    lastMax = max;
                    max = 0;
                }
            }

        }
*/
        //worst
        int counter = 0;
        for(int i = 0; i < meanMinus.size(); i++) {
            if(meanPlus.size() > 0 && meanPlus.size() >= counter + 1){
                for (int k = 0; k < chromoCount; k++) {
                    meanMinus.get(i).setMove(k, meanPlus.get(counter).getStrategy().get(k));
                }
                counter++;
            }
            else if(meanPlus.size() > 0){
                counter = 0;
            }

        }
        //best
        if(meanPlus.size() % 2 == 0){
            for(int i = 0; i < meanPlus.size(); i+=2) {
                int cross = random.nextInt(chromoCount);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanPlus.get(i).getStrategy());
                for (int j = cross; j < chromoCount; j++) {
                    if(random.nextInt(mutationRation) == 1){
                        if(meanPlus.get(i + 1).getStrategy().get(j) == 0){
                            meanPlus.get(i).setMove(j, 1);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanPlus.get(i).setMove(j, 0);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanPlus.get(i).setMove(j, meanPlus.get(i + 1).getStrategy().get(j));
                        meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }
                }
            }
        } else{
            for(int i = 1; i < meanPlus.size(); i+=2) {
                int cross = random.nextInt(chromoCount);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanPlus.get(i).getStrategy());
                for (int j = cross; j < chromoCount; j++) {
                    if(random.nextInt(mutationRation) == 1){
                        if(meanPlus.get(i + 1).getStrategy().get(j) == 0){
                            meanPlus.get(i).setMove(j, 1);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanPlus.get(i).setMove(j, 0);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanPlus.get(i).setMove(j, meanPlus.get(i + 1).getStrategy().get(j));
                        meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }
                }
            }
        }
    }

    void reproducev2(){
        for(int i = 0; i < prison.getPrisonersCount(); i++){
            if(prison.getPrisoners().get(i).getScore() > mean){
                meanPlus.add(prison.getPrisoners().get(i));
            } else {
                meanMinus.add(prison.getPrisoners().get(i));
            }
        }

        //standard
        if(meanEqual.size() % 2 == 0){
            for(int i = 0; i < meanEqual.size(); i+=2) {
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanEqual.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    if(random.nextInt(100) == 1){
                        if(meanEqual.get(i + 1).getStrategy().get(j) == 0){
                            meanEqual.get(i).setMove(j, 1);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanEqual.get(i).setMove(j, 0);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanEqual.get(i).setMove(j, meanEqual.get(i + 1).getStrategy().get(j));
                        meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }

                }
            }
        }
        else{
            for(int i = 1; i < meanEqual.size(); i+=2) {
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanEqual.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    if(random.nextInt(100) == 1){
                        if(meanEqual.get(i + 1).getStrategy().get(j) == 0){
                            meanEqual.get(i).setMove(j, 1);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanEqual.get(i).setMove(j, 0);
                            meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanEqual.get(i).setMove(j, meanEqual.get(i + 1).getStrategy().get(j));
                        meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }
                }
            }
        }

        //wors
        int max = 0;
        int lastMax = 0;
        for(int i = 0; i < meanMinus.size(); i+=2) {

            Prisoner moved = new Prisoner();
            for(int j = 0; j < meanPlus.size(); j++){
                if(meanPlus.get(j).getScore() > max && meanPlus.get(j).getScore() != lastMax){
                    max = meanPlus.get(j).getScore();
                }
            }
            for(int j = 0; j < meanPlus.size(); j++){
                if(meanPlus.get(j).getScore() == max){
                    for (int k = 0; k < 64; k++) {
                        meanMinus.get(i).setMove(k, meanPlus.get(j).getStrategy().get(k));
                    }
                    lastMax = max;
                    max = 0;
                }
            }

        }

        //best
        if(meanPlus.size() % 2 == 0){
            for(int i = 0; i < meanPlus.size(); i+=2) {
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanPlus.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    if(random.nextInt(100) == 1){
                        if(meanPlus.get(i + 1).getStrategy().get(j) == 0){
                            meanPlus.get(i).setMove(j, 1);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanPlus.get(i).setMove(j, 0);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanPlus.get(i).setMove(j, meanPlus.get(i + 1).getStrategy().get(j));
                        meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }
                }
            }
        } else{
            for(int i = 1; i < meanPlus.size(); i+=2) {
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanPlus.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    if(random.nextInt(100) == 1){
                        if(meanPlus.get(i + 1).getStrategy().get(j) == 0){
                            meanPlus.get(i).setMove(j, 1);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }
                        else{
                            meanPlus.get(i).setMove(j, 0);
                            meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                        }

                    } else {
                        meanPlus.get(i).setMove(j, meanPlus.get(i + 1).getStrategy().get(j));
                        meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                    }
                }
            }
        }
    }
  /*  void reproducev3(){
        int margin = (int) (prison.getPrisonersCount() * 0.3);
        for(int i = 0; i < prison.getPrisonersCount(); i++){

            if(prison.getPrisoners().get(i).getScore() > mean){
                meanPlus.add(prison.getPrisoners().get(i));
            } else {
                meanMinus.add(prison.getPrisoners().get(i));
            }
        }
    }*/
}
