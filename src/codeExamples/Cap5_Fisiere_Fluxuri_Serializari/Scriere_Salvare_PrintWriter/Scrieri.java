package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.Scriere_Salvare_PrintWriter;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scrieri extends Frame implements ActionListener {
        private TextArea intrareArieText;
        private Button butonSalvare;

        //Constructorul clasei
        //Stabileste titlul ferestrei
        public Scrieri() {
            super("Scrieri");
        }

        public static void main(String[] args) {
        Scrieri f = new Scrieri();
        f.setSize(200, 200);
        f.interfataGrafica();
        f.setVisible(true);
    }

        //crearea elementelor grafice si adaugarea acestora la fereastra aplicatiei
        public void interfataGrafica() {
            butonSalvare = new Button("save");
            add("North", butonSalvare);
            butonSalvare.addActionListener(this);
            intrareArieText = new TextArea(10,50);
            add("Center", intrareArieText);
            //ascultator pentru inchiderea ferestrei
            addWindowListener(new WindowAdapter() {
            // aceasta metoda este apelata automat cand se apasa
                // butonul pentru inchiderea ferestrei aplicatiei
                public void windowClosing(WindowEvent event) {
                    System.exit(0);
                }
            });
        }

        //aceasta metoda este apelata cand s-a apasat butonul 'save'
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == butonSalvare) {
                PrintWriter fisierIesire = null;
                try {
                    //salvarea textului in fisier
                    fisierIesire = new PrintWriter(new FileWriter("fisier.txt"),true);
                    fisierIesire.println(intrareArieText.getText());
                } catch (IOException e) {
                    System.err.println("Eroare de fisier: " + e.toString());
                    System.exit(1);
                }
                finally {
                    if(fisierIesire != null)
                        fisierIesire.close();
                }

            }
        }
}
