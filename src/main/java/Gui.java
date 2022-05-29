import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Gui extends JFrame{
    private JButton button1;
    private JPanel panel1;
    private JTextField populationCount;
    private JTextField interrogationCountPrisoner;
    private JTextField interrogationCount;

    public Gui() {
        setContentPane(panel1);
        setTitle("Test");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("Enter population count: ");
                int mean = 0;
                Prison prison = new Prison(Integer.parseInt(populationCount.getText()), Integer.parseInt(interrogationCountPrisoner.getText()));
                File file = new File("logs.txt");
                file.delete();
                try {
                    BufferedWriter logs = new BufferedWriter(new FileWriter("logs.txt", true));
                    for(int i = 0; i < Integer.parseInt(interrogationCount.getText()); i++){

                        prison.interrogation();
                        EvolutionEngine evolutionEngine = new EvolutionEngine(prison);
                        evolutionEngine.calculateMean();
                        mean = evolutionEngine.getMean();
                        logs.append(Integer.toString(mean) + '\n');
                        for(int j = 0; j < Integer.parseInt(populationCount.getText()); j++){
                            for(int k = 0; k < 85; k++){
                                logs.append(prison.getPrisoners().get(j).getStrategy().get(k).toString());
                            }
                            logs.append('\n');
                        }
                       // System.out.println(mean);
                        evolutionEngine.reproduce();

                    }
                    logs.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
