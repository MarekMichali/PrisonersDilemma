import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

public class Main {
    // 2.) Definition of the fitness function. zawsze zwraca inta, im wiekszy tym lepiej poszlo
    private static int eval(Genotype<BitGene> gt) {

      // int x = gt.chromosome()
      //         .as(BitChromosome.class)
      //         .bitCount();

        int x1 = gt.get(0)
                .as(BitChromosome.class)
                .bitCount();
        int x2 = gt.get(1)
                .as(BitChromosome.class)
                .bitCount();
        int x3 = gt.get(2)
                .as(BitChromosome.class)
                .bitCount();

        return x1+x2+x3;
    }

    public static void main(String[] args) {
        // 1.) Define the genotype (factory) suitable
        //     for the problem.
        Factory<Genotype<BitGene>> gtf =
                Genotype.of(BitChromosome.of(10, 0.5),
                        BitChromosome.of(6, 0.5),
                        BitChromosome.of(21, 0.5));
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