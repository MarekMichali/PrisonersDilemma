
//mozliwosci kazdego rouchu 00-01-10-11
//3 ostatnie ruchy xx-xx-xx czyli 4*4*4=64 mozliwosci
//3 pierwsze ruchy generowac losowo

public class Main {
    public static void main(String[] args) {
        System.out.println("Before");
        int mean = 0;
        Prison prison = new Prison(20);
        for(int i = 0; i < 1000; i++){
            prison.interrogation();
            EvolutionEngine evolutionEngine = new EvolutionEngine(prison);
            evolutionEngine.calculateMean();
            mean = evolutionEngine.getMean();
            System.out.println(mean);
            evolutionEngine.reproduce();
        }

        System.out.println(mean);

    }
}