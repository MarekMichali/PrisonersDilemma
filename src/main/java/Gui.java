import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Gui extends JFrame{
    private JButton button1;
    private JPanel panel;
    private JPanel Card1;
    private JPanel Card2;
    private JTextField populationCount;
    private JTextField interrogationCountPrisoner;
    private JTextField interrogationCount;
    private JButton button2;

    public Gui() {
        setContentPane(panel);
        setTitle("Test");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
      /*  DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

        ds.addSeries("series1", data);

        XYDataset ds2 = ds;
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                "x", "y", ds, PlotOrientation.VERTICAL, true, true,
                false);

        ChartPanel cp = new ChartPanel(chart);

        getContentPane().add(cp);*/
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

                Statistic statistic = new Statistic("logs.txt", Integer.parseInt(populationCount.getText()), Integer.parseInt(interrogationCount.getText()) );
                try {
                    statistic.generateStatics();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }


                //DefaultXYDataset ds = new DefaultXYDataset();
                var dataset = new XYSeries("mean");
                for(int i = 0; i <  statistic.getMeans().size(); i++){
                    dataset.add(i, (double)statistic.getMeans().get(i));
                 //   dataset.
                }
              //  double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

             //   ds.addSeries("series1", data);

                var ds = new XYSeriesCollection();
                ds.addSeries(dataset);

                XYDataset ds2 = ds;
                JFreeChart chart = ChartFactory.createXYLineChart("Statistic",
                        "population number", "population mean", ds, PlotOrientation.VERTICAL, true, true,
                        false);

                ChartPanel cp = new ChartPanel(chart);


                panel.removeAll();
                panel.add(cp);
              //  panel.add(Card2);

                panel.repaint();
                panel.revalidate();


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(Card1);
                panel.repaint();
                panel.revalidate();

            }
        });
    }

    public void createChart(){
        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

        ds.addSeries("series1", data);

       // XYDataset ds2 = ds;
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                "x", "y", ds, PlotOrientation.VERTICAL, true, true,
                false);

        ChartPanel cp = new ChartPanel(chart);

        panel.add(cp);
    }
}
