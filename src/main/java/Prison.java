import java.util.ArrayList;
import java.util.List;

//moves coding
//00 -> 0
//01 -> 1
//10 -> 2
//11 -> 3

public class Prison {
    private List<Prisoner> prisoners = new ArrayList<>();
    private int prisonersCount;
    Prison(int prisonersCount){
        this.prisonersCount = prisonersCount;
        for(int i = 0; i < prisonersCount; i++){
            prisoners.add(new Prisoner());
        }
    }


    void interrogation(){
        for(int i = 0; i < prisonersCount; i++){
            Prisoner interrogated = prisoners.get(i);
            List<Integer> interrogatedStrategy = interrogated.getStrategy();
            for(int j = 0; j < prisonersCount; j++){
                switch (interrogated.getLastThreeMoves().get(0)){
                    case 0:
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
                    case 1:
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

    void interrogation2(int whoID, int withID){
        Prisoner who = prisoners.get(whoID);
        Prisoner with = prisoners.get(withID);
        List<Integer> whoStrategy = who.getStrategy();
        List<Integer> withStrategy = with.getStrategy();
    }
}
