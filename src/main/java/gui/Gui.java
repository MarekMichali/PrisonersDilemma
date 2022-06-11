package gui;

import logic.EvolutionEngine;
import logic.Prison;
import logic.Statistic;
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
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame{
    private JButton button1;
    private JPanel panel;
    private JTextField populationCount;
    private JTextField numberOfInterrogations;
    private JTextField interrogationCount;
    private JPanel innerPanel;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private int state = 0;
    private int mean = 0;
    private int numOfIt = 20;
    private int popCount = 20;
    private int interCount = 20;
    private List<Integer> result = new ArrayList<>();
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();



    public Gui() {
        firstLabel.setPreferredSize(new Dimension(50, 20));
        firstLabel.setPreferredSize(new Dimension(50, 20));
        firstLabel.setPreferredSize(new Dimension(50, 20));
        setContentPane(panel);
        setTitle("Prisoners dilemma");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width-100, height-100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(state == 1){
                    innerPanel.removeAll();
                    //JButton b=new JButton("Click Here");
                   // JTextField t1=new JTextField();
                    t1.setPreferredSize(new Dimension(40,20));

                    t2.setPreferredSize(new Dimension(40,20));

                    t3.setPreferredSize(new Dimension(40,20));

                   // cp.setPreferredSize(new Dimension((panel.getWidth()-100), (panel.getHeight()-100)));
                    innerPanel.add(t1);
                    innerPanel.add(t2);
                    innerPanel.add(t3);

                    // innerPanel.add(b);
                    innerPanel.revalidate();
                    innerPanel.repaint();
                    state = 2;
                    return;
                }
                if(state == 2){
                    //Statistic statistic = new Statistic("logs.txt", popCount, interCount );
                    String last1 = "-1";
                    String last2 = "-1";
                    String last3 = "-1";
                    String message = "surrender";
                    if (t1.getText() != null && t1.getText().matches("\\d+")){
                        last1 = t1.getText();
                    }
                    if (t2.getText() != null && t2.getText().matches("\\d+")){
                        last2 = t2.getText();
                    }
                    if (t3.getText() != null && t3.getText().matches("\\d+")){
                        last3 = t3.getText();
                    }


                    if(last1.equals("-1")){
                        message = result.get(64).toString();
                    }
                    else if(last1.equals("00")){
                        if(last2.equals("-1")){
                            message = result.get(65).toString();
                        }
                        else if(last2.equals("00")){
                            if(last3.equals("-1")){
                                message = result.get(69).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(0).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(1).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(2).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(3).toString();
                            }
                        }
                        else if(last2.equals("01")){
                            if(last3.equals("-1")){
                                message = result.get(70).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(4).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(5).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(6).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(7).toString();
                            }
                        }
                        else if(last2.equals("10")){
                            if(last3.equals("-1")){
                                message = result.get(71).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(8).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(9).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(10).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(11).toString();
                            }
                        }
                        else if(last2.equals("11")){
                            if(last3.equals("-1")){
                                message = result.get(72).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(12).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(13).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(14).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(15).toString();
                            }
                        }
                    }

                    else if(last1.equals("01")){
                        if(last2.equals("-1")){
                            message = result.get(66).toString();
                        }
                        else if(last2.equals("00")){
                            if(last3.equals("-1")){
                                message = result.get(73).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(16).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(17).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(18).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(19).toString();
                            }
                        }
                        else if(last2.equals("01")){
                            if(last3.equals("-1")){
                                message = result.get(74).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(20).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(21).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(22).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(23).toString();
                            }
                        }
                        else if(last2.equals("10")){
                            if(last3.equals("-1")){
                                message = result.get(75).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(24).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(25).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(26).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(27).toString();
                            }
                        }
                        else if(last2.equals("11")){
                            if(last3.equals("-1")){
                                message = result.get(76).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(28).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(29).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(30).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(31).toString();
                            }
                        }
                    }

                    else if(last1.equals("10")){
                        if(last2.equals("-1")){
                            message = result.get(67).toString();
                        }
                        else if(last2.equals("00")){
                            if(last3.equals("-1")){
                                message = result.get(77).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(32).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(33).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(34).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(35).toString();
                            }
                        }
                        else if(last2.equals("01")){
                            if(last3.equals("-1")){
                                message = result.get(78).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(36).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(37).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(38).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(39).toString();
                            }
                        }
                        else if(last2.equals("10")){
                            if(last3.equals("-1")){
                                message = result.get(79).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(40).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(41).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(42).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(43).toString();
                            }
                        }
                        else if(last2.equals("11")){
                            if(last3.equals("-1")){
                                message = result.get(80).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(44).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(45).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(46).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(47).toString();
                            }
                        }
                    }

                    else if(last1.equals("11")){
                        if(last2.equals("-1")){
                            message = result.get(68).toString();
                        }
                        else if(last2.equals("00")){
                            if(last3.equals("-1")){
                                message = result.get(81).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(48).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(49).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(50).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(51).toString();
                            }
                        }
                        else if(last2.equals("01")){
                            if(last3.equals("-1")){
                                message = result.get(82).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(52).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(53).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(54).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(55).toString();
                            }
                        }
                        else if(last2.equals("10")){
                            if(last3.equals("-1")){
                                message = result.get(83).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(56).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(57).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(58).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(59).toString();
                            }
                        }
                        else if(last2.equals("11")){
                            if(last3.equals("-1")){
                                message = result.get(84).toString();
                            }
                            else if(last3.equals("00")){
                                message = result.get(60).toString();
                            }
                            else if(last3.equals("01")){
                                message = result.get(61).toString();
                            }
                            else if(last3.equals("10")){
                                message = result.get(62).toString();
                            }
                            else if(last3.equals("11")){
                                message = result.get(63).toString();
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(new JFrame(), message, "Move",
                            JOptionPane.INFORMATION_MESSAGE);

                    return;
                }
                state = 1;

                if (numberOfInterrogations.getText() != null && numberOfInterrogations.getText().matches("\\d+")){
                    numOfIt = Integer.parseInt(numberOfInterrogations.getText());
                }
                if (populationCount.getText() != null && populationCount.getText().matches("\\d+")){
                    popCount = Integer.parseInt(populationCount.getText());
                }
                if (interrogationCount.getText() != null && interrogationCount.getText().matches("\\d+")){
                    interCount = Integer.parseInt(interrogationCount.getText());
                }



                Prison prison = new Prison(popCount, numOfIt);
                File file = new File("logs.txt");
                file.delete();
                try {
                    BufferedWriter logs = new BufferedWriter(new FileWriter("logs.txt", true));
                    int i = 0;
                    for(; i < interCount - 1; i++){ //1 mmiej zrbic i zapisac gdzues do wktora
                        prison.interrogation();
                        EvolutionEngine evolutionEngine = new EvolutionEngine(prison);
                        evolutionEngine.calculateMean();
                        mean = evolutionEngine.getMean();
                        logs.append(Integer.toString(mean) + '\n');
                        for(int j = 0; j < popCount; j++){
                            for(int k = 0; k < 85; k++){
                                logs.append(prison.getPrisoners().get(j).getStrategy().get(k).toString());
                            }
                            logs.append('\n');
                        }
                        evolutionEngine.reproduce();
                    }
                    prison.interrogation();
                    EvolutionEngine evolutionEngine = new EvolutionEngine(prison);
                    evolutionEngine.calculateMean();
                    mean = evolutionEngine.getMean();
                    logs.append(Integer.toString(mean) + '\n');
                    for(int j = 0; j < 85; j++){
                        result.add(0);
                    }
                    for(int j = 0; j < popCount; j++){
                        for(int k = 0; k < 85; k++){
                            logs.append(prison.getPrisoners().get(j).getStrategy().get(k).toString());
                           // result. do wektora
                            result.set(k, result.get(k) + prison.getPrisoners().get(j).getStrategy().get(k));
                        }
                        logs.append('\n');
                    }
                    evolutionEngine.reproduce();
                    for(int k = 0; k < 85; k++){
                       // logs.append(prison.getPrisoners().get(j).getStrategy().get(k).toString());
                        // result. do wektora

                        result.set(k, Math.round(result.get(k)/(float) popCount)); //blS
                    }




                    logs.close();
                    Statistic statistic = new Statistic("logs.txt", popCount, interCount );
                    try {
                        statistic.generateStatics();
                        ChartPanel cp = new ChartPanel(generateChart(statistic));
                      //  cp.setDomainZoomable(true);
                        innerPanel.removeAll();
                        JButton b=new JButton("Click Here");
                        cp.setPreferredSize(new Dimension((panel.getWidth()-100), (panel.getHeight()-100)));
                        innerPanel.add(cp);
                       // innerPanel.add(b);
                        innerPanel.revalidate();
                        innerPanel.repaint();

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