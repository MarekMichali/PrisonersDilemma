
//mozliwosci kazdego rouchu 00-01-10-11
//3 ostatnie ruchy xx-xx-xx czyli 4*4*4=64 mozliwosci
//3 pierwsze ruchy generowac losowo


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui();
            }
        });
    }
}