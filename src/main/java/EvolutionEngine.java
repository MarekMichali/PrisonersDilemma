import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvolutionEngine {
    private Prison prison;

    public int getMean() {
        return mean;
    }

    private int mean;
    int standardDeviation = 0;
    private Random random = new Random();
    private List<Prisoner> meanPlus = new ArrayList<>();
    private List<Prisoner> meanEqual = new ArrayList<>();
    private List<Prisoner> meanMinus = new ArrayList<>();

    EvolutionEngine(Prison prison){
        this.prison=prison;
    }

    void calculateMean(){
        int prisonCount = prison.getPrisonersCount();
        this.mean = prison.getPrisonScore() / prisonCount;
        for(int i = 0; i < prisonCount; i++){
            standardDeviation += (int) Math.pow(prison.getPrisoners().get(i).getScore() - mean, 2);
        }
        standardDeviation = standardDeviation / prisonCount;
        standardDeviation = (int) Math.sqrt(standardDeviation);

    }

    void reproduce(){
        for(int i = 0; i < prison.getPrisonersCount(); i++){
            if(prison.getPrisoners().get(i).getScore() > mean + standardDeviation){
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
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanEqual.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    meanEqual.get(i).setMove(j, meanEqual.get(i + 1).getStrategy().get(j));
                    meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                }
            }
        } else{
            for(int i = 1; i < meanEqual.size(); i+=2) {
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanEqual.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    meanEqual.get(i).setMove(j, meanEqual.get(i + 1).getStrategy().get(j));
                    meanEqual.get(i + 1).setMove(j, strategyCopyLeft.get(j));
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
                    meanPlus.get(i).setMove(j, meanPlus.get(i + 1).getStrategy().get(j));
                    meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                }
            }
        } else{
            for(int i = 1; i < meanPlus.size(); i+=2) {
                int cross = random.nextInt(64);
                List<Integer> strategyCopyLeft = new ArrayList<>(meanPlus.get(i).getStrategy());
                for (int j = cross; j < 64; j++) {
                    meanPlus.get(i).setMove(j, meanPlus.get(i + 1).getStrategy().get(j));
                    meanPlus.get(i + 1).setMove(j, strategyCopyLeft.get(j));
                }
            }
        }
    }
}
