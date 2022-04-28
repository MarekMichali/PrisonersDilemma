import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

import java.util.ArrayList;
import java.util.List;


//mozliwosci kazdego rouchu 00-01-10-11
//3 ostatnie ruchy xx-xx-xx czyli 4*4*4=64 mozliwosci
//3 pierwsze ruchy generowac losowo

public class Main {
    // 2.) Definition of the fitness function. zawsze zwraca inta, im wiekszy tym lepiej poszlo
    private static int eval(Genotype<BitGene> gt) {
        List<Prisoner> prison = new ArrayList<>();
        int prisonersCount = gt.geneCount()/64;
        for(int i = 0; i < prisonersCount; i++){
            prison.add(new Prisoner(gt.get(i)
                    .as(BitChromosome.class)));
        }


       // Prisoner x;
      // int x = gt.chromosome()
      //         .as(BitChromosome.class)
      //         .bitCount();
/*
        int x1 = gt.get(0)
                .as(BitChromosome.class)
                .bitCount();
        int x2 = gt.get(1)
                .as(BitChromosome.class)
                .bitCount();
        int x3 = gt.get(2)
                .as(BitChromosome.class)
                .bitCount();
        int chromoCount = gt.geneCount();
        return x1-x2+x3;

 */
        return 1;
    }

    public static void main(String[] args) {
        // 1.) Define the genotype (factory) suitable
        //     for the problem.
        Factory<Genotype<BitGene>> gtf =
                Genotype.of(BitChromosome.of(64, 0.5),
                        BitChromosome.of(64, 0.5),
                        BitChromosome.of(64, 0.5));
        System.out.println("przed:\n" + gtf);
        // 3.) Create the execution environment.
        Engine<BitGene, Integer> engine = Engine
                .builder(Main::eval, gtf)
                .build();

        // 4.) Start the execution (evolution) and
        //     collect the result.
        Genotype<BitGene> result = engine.stream()
                .limit(100)
                .collect(EvolutionResult.toBestGenotype());

        System.out.println("Hello World:\n" + result);
    }
}