import java.util.ArrayList;
import java.util.List;

//moves coding
//00 -> 0
//01 -> 1
//10 -> 2
//11 -> 3

//1 -> cooperate
//0 -> betray
public class Prison {
    public List<Prisoner> getPrisoners() {
        return prisoners;
    }

    private List<Prisoner> prisoners = new ArrayList<>();
    private int prisonersCount;
    private int numberOfInterrogations = 20;
    Prison(int prisonersCount){
        this.prisonersCount = prisonersCount;
        for(int i = 0; i < prisonersCount; i++){
            prisoners.add(new Prisoner());
        }
    }

    public int getPrisonScore(){
        int scoreSum = 0;
        for(int i = 0; i < prisonersCount; i++){
            scoreSum += prisoners.get(0).getScore();
        }
        return scoreSum;
    }
    public int getPrisonersCount() {
        return prisonersCount;
    }
    void calculateScore(int left, int right, Prisoner interrogated, Prisoner interrogatedWith){
        if(left == right && left == 1){
            interrogated.changeScore(3);
            interrogatedWith.changeScore(3);
            interrogated.setLastMove(3);
            interrogatedWith.setLastMove(3);
        } else if (left == right && left == 0) {
            interrogated.changeScore(1);
            interrogatedWith.changeScore(1);
            interrogated.setLastMove(0);
            interrogatedWith.setLastMove(0);
        } else if (left > right) {
            interrogated.changeScore(0);
            interrogatedWith.changeScore(5);
            interrogated.setLastMove(2);
            interrogatedWith.setLastMove(1);
        } else if (left < right) {
            interrogated.changeScore(5);
            interrogatedWith.changeScore(0);
            interrogated.setLastMove(1);
            interrogatedWith.setLastMove(2);
        }
    }
    void interrogation(){
        for(int i = 0; i < prisonersCount; i++){
            prisoners.get(i).changeScore(-prisoners.get(i).getScore());
        }
        int left;
        int right;
        for(int i = 0; i < prisonersCount - 1; i++){
            Prisoner interrogated = prisoners.get(i);
            List<Integer> interrogatedStrategy = interrogated.getStrategy();
            for(int j = i + 1; j < prisonersCount; j++){
                Prisoner interrogatedWith = prisoners.get(j);
                List<Integer> interrogatedStrategyWith = interrogatedWith.getStrategy();
                for(int k = 0; k < numberOfInterrogations; k++){
                    switch (interrogated.getLastThreeMoves().get(0)){
                    case 0: //00
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0: //00-00
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(0), interrogatedStrategyWith.get(0), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(1), interrogatedStrategyWith.get(2), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(2), interrogatedStrategyWith.get(1), interrogated, interrogatedWith);
                                        break;
                                    case 3: //00
                                        calculateScore(interrogatedStrategy.get(3), interrogatedStrategyWith.get(3), interrogated, interrogatedWith);
                                        break;
                                }
                                break;
                            case 1: //00-01
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(4), interrogatedStrategyWith.get(8), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(5), interrogatedStrategyWith.get(10), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(6), interrogatedStrategyWith.get(9), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(7), interrogatedStrategyWith.get(11), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 2: //00-10
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(8), interrogatedStrategyWith.get(4), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(9), interrogatedStrategyWith.get(6), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(10), interrogatedStrategyWith.get(5), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(11), interrogatedStrategyWith.get(7), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 3: //00-11
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(12), interrogatedStrategyWith.get(12), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(13), interrogatedStrategyWith.get(14), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(14), interrogatedStrategyWith.get(13), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(15), interrogatedStrategyWith.get(15), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                        }
                        break;
                    case 1: //01
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0: //01-00
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(16), interrogatedStrategyWith.get(32), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(17), interrogatedStrategyWith.get(34), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(18), interrogatedStrategyWith.get(33), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(19), interrogatedStrategyWith.get(35), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 1: //01-01
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(20), interrogatedStrategyWith.get(40), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(21), interrogatedStrategyWith.get(42), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(22), interrogatedStrategyWith.get(41), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(23), interrogatedStrategyWith.get(43), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 2: //01-10
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(24), interrogatedStrategyWith.get(36), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(25), interrogatedStrategyWith.get(38), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(26), interrogatedStrategyWith.get(37), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(27), interrogatedStrategyWith.get(39), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 3: //01-11
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(28), interrogatedStrategyWith.get(44), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(29), interrogatedStrategyWith.get(46), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(30), interrogatedStrategyWith.get(45), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(31), interrogatedStrategyWith.get(47), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                        }
                        break;
                    case 2: //10
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0: //10-00
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(32), interrogatedStrategyWith.get(16), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(33), interrogatedStrategyWith.get(18), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(34), interrogatedStrategyWith.get(17), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(35), interrogatedStrategyWith.get(19), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 1: //10-01
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(36), interrogatedStrategyWith.get(24), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(37), interrogatedStrategyWith.get(26), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(38), interrogatedStrategyWith.get(25), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(39), interrogatedStrategyWith.get(27), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 2: //10-10
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(40), interrogatedStrategyWith.get(20), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(41), interrogatedStrategyWith.get(22), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(42), interrogatedStrategyWith.get(21), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(43), interrogatedStrategyWith.get(23), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 3: //10-11
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(44), interrogatedStrategyWith.get(28), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(45), interrogatedStrategyWith.get(30), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(46), interrogatedStrategyWith.get(29), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(47), interrogatedStrategyWith.get(31), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                        }
                        break;
                    case 3: //11
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0: //11-00
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(48), interrogatedStrategyWith.get(48), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(49), interrogatedStrategyWith.get(50), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(50), interrogatedStrategyWith.get(49), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(51), interrogatedStrategyWith.get(51), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 1: //11-01
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(52), interrogatedStrategyWith.get(56), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(53), interrogatedStrategyWith.get(58), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(54), interrogatedStrategyWith.get(57), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(55), interrogatedStrategyWith.get(59), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 2: //11-10
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(56), interrogatedStrategyWith.get(52), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(57), interrogatedStrategyWith.get(54), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(58), interrogatedStrategyWith.get(53), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(59), interrogatedStrategyWith.get(55), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                            case 3: //11-11
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0: //00
                                        calculateScore(interrogatedStrategy.get(60), interrogatedStrategyWith.get(60), interrogated, interrogatedWith);
                                        break;
                                    case 1: //01
                                        calculateScore(interrogatedStrategy.get(61), interrogatedStrategyWith.get(62), interrogated, interrogatedWith);
                                        break;
                                    case 2: //10
                                        calculateScore(interrogatedStrategy.get(62), interrogatedStrategyWith.get(61), interrogated, interrogatedWith);
                                        break;
                                    case 3: //11
                                        calculateScore(interrogatedStrategy.get(63), interrogatedStrategyWith.get(63), interrogated, interrogatedWith);
                                        break;

                                }
                                break;
                        }
                        break;
                    }
                }
            }
        }
    }

    void interrogation2(int whoID, int withID){
        Prisoner who = prisoners.get(whoID);
        Prisoner with = prisoners.get(withID);
        List<Integer> whoStrategy = who.getStrategy();
        List<Integer> withStrategy = with.getStrategy();
    }
}
