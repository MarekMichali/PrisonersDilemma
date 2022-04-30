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
    private List<Prisoner> prisoners = new ArrayList<>();
    private int prisonersCount;
    private int numberOfInterrogations = 20;
    Prison(int prisonersCount){
        this.prisonersCount = prisonersCount;
        for(int i = 0; i < prisonersCount; i++){
            prisoners.add(new Prisoner());
        }
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
        int left;
        int right;
        for(int i = 0; i < prisonersCount; i++){
            Prisoner interrogated = prisoners.get(i);
            List<Integer> interrogatedStrategy = interrogated.getStrategy();
            for(int j = i + 1; j < prisonersCount; j++){
                Prisoner interrogatedWith = prisoners.get(j);
                List<Integer> interrogatedStrategyWith = interrogatedWith.getStrategy();
                for(int k = 0; k < numberOfInterrogations; k++){
                    switch (interrogated.getLastThreeMoves().get(0)){
                    case 0:
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        calculateScore(interrogatedStrategy.get(0), interrogatedStrategyWith.get(0), interrogated, interrogatedWith);
                                        break;
                                    case 1:
                                        calculateScore(interrogatedStrategy.get(1), interrogatedStrategyWith.get(1), interrogated, interrogatedWith);
                                        break;
                                    case 2:
                                        calculateScore(interrogatedStrategy.get(2), interrogatedStrategyWith.get(2), interrogated, interrogatedWith);
                                        break;
                                    case 3:
                                        calculateScore(interrogatedStrategy.get(3), interrogatedStrategyWith.get(3), interrogated, interrogatedWith);
                                        break;
                                }
                            case 1:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        calculateScore(interrogatedStrategy.get(4), interrogatedStrategyWith.get(4), interrogated, interrogatedWith);
                                        break;
                                    case 1:
                                        calculateScore(interrogatedStrategy.get(5), interrogatedStrategyWith.get(5), interrogated, interrogatedWith);
                                        break;
                                    case 2:
                                        calculateScore(interrogatedStrategy.get(6), interrogatedStrategyWith.get(6), interrogated, interrogatedWith);
                                        break;
                                    case 3:
                                        calculateScore(interrogatedStrategy.get(7), interrogatedStrategyWith.get(7), interrogated, interrogatedWith);
                                        break;

                                }
                            case 2:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        calculateScore(interrogatedStrategy.get(8), interrogatedStrategyWith.get(8), interrogated, interrogatedWith);
                                        break;
                                    case 1:
                                        calculateScore(interrogatedStrategy.get(9), interrogatedStrategyWith.get(9), interrogated, interrogatedWith);
                                        break;
                                    case 2:
                                        calculateScore(interrogatedStrategy.get(10), interrogatedStrategyWith.get(10), interrogated, interrogatedWith);
                                        break;
                                    case 3:
                                        calculateScore(interrogatedStrategy.get(11), interrogatedStrategyWith.get(11), interrogated, interrogatedWith);
                                        break;

                                }
                            case 3:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        calculateScore(interrogatedStrategy.get(12), interrogatedStrategyWith.get(12), interrogated, interrogatedWith);
                                        break;
                                    case 1:
                                        calculateScore(interrogatedStrategy.get(13), interrogatedStrategyWith.get(13), interrogated, interrogatedWith);
                                        break;
                                    case 2:
                                        calculateScore(interrogatedStrategy.get(14), interrogatedStrategyWith.get(14), interrogated, interrogatedWith);
                                        break;
                                    case 3:
                                        calculateScore(interrogatedStrategy.get(15), interrogatedStrategyWith.get(15), interrogated, interrogatedWith);
                                        break;

                                }

                        }
                    case 1:
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        calculateScore(interrogatedStrategy.get(16), interrogatedStrategyWith.get(16), interrogated, interrogatedWith);
                                        break;
                                    case 1:
                                        calculateScore(interrogatedStrategy.get(17), interrogatedStrategyWith.get(17), interrogated, interrogatedWith);
                                        break;
                                    case 2:
                                        calculateScore(interrogatedStrategy.get(18), interrogatedStrategyWith.get(18), interrogated, interrogatedWith);
                                        break;
                                    case 3:
                                        calculateScore(interrogatedStrategy.get(19), interrogatedStrategyWith.get(19), interrogated, interrogatedWith);
                                        break;

                                }
                            case 1:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 2:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 3:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }

                        }
                    case 2:
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 1:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 2:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 3:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }

                        }
                    case 3:
                        switch (interrogated.getLastThreeMoves().get(1)){
                            case 0:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 1:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 2:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }
                            case 3:
                                switch (interrogated.getLastThreeMoves().get(2)){
                                    case 0:
                                        return;
                                    case 1:
                                        return;
                                    case 2:
                                        return;
                                    case 3:
                                        return;

                                }

                        }

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
