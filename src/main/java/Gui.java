import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
    private JTextField populationCount;
    private JTextField numberOfInterrogations;
    private JTextField interrogationCount;

    public Gui() {
        setContentPane(panel);
        setTitle("Test");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mean = 0;
                Prison prison = new Prison(Integer.parseInt(populationCount.getText()), Integer.parseInt(numberOfInterrogations.getText()));
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
                        evolutionEngine.reproduce();
                    }
                    logs.close();
                    Statistic statistic = new Statistic("logs.txt", Integer.parseInt(populationCount.getText()), Integer.parseInt(interrogationCount.getText()) );
                    try {
                        statistic.generateStatics();
                        ChartPanel cp = new ChartPanel(generateChart(statistic));
                        panel.removeAll();
                        panel.add(cp);
                        panel.repaint();
                        panel.revalidate();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }



            }
        });

    }
    private JFreeChart generateChart(Statistic statistic){
        var dataset = new XYSeries("mean");
        for(int i = 0; i <  statistic.getMeans().size(); i++){
            dataset.add(i, (double)statistic.getMeans().get(i));
        }
        var ds = new XYSeriesCollection();
        ds.addSeries(dataset);
        JFreeChart chart = ChartFactory.createXYLineChart("Statistic",
                "generation", "generation mean", ds, PlotOrientation.VERTICAL, true, true,
                false);
        Integer minimum = statistic.getMeans().stream().mapToInt(num -> num).min().orElse(0);
        chart.getXYPlot().getRangeAxis().setLowerBound(minimum + -100);
        return chart;
    }

}
