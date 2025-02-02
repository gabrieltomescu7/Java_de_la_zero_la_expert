package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.Citiri.Citiri_Fisier_FileReader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Citiri extends Frame implements ActionListener {
    private TextArea arieTextIntrare;
    private Button butonLoad;
    private TextField numeCamp;

    public static void main(String[] args) {
        Citiri f = new Citiri();
        f.setBounds(200, 100, 300, 200);
        f.interfataGrafica();
        f.setTitle("Citiri \uD83D\uDE0A");
        f.setVisible(true);
    }

    //crearea elementelor grafice si adaugarea acestora la fereastra aplicatie
    public void interfataGrafica() {
        Panel top = new Panel();
        butonLoad = new Button("load");
        top.add(butonLoad);
        butonLoad.addActionListener(this);
        numeCamp = new TextField(20);
        top.add(numeCamp);
        numeCamp.addActionListener(this);
        add("North", top);
        arieTextIntrare = new TextArea("", 10, 50);
        add("Center", arieTextIntrare);
        //stabilim un ascultator pentru inchiderea ferestrei
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == butonLoad) {
            String numeFisier;
            numeFisier = numeCamp.getText();
            BufferedReader fisierIntrare = null;
            try {
                fisierIntrare = new BufferedReader(new FileReader(numeFisier));
                arieTextIntrare.setText(""); // stergem continutul ariei text
                String linie;
                while((linie = fisierIntrare.readLine()) != null) {
                    arieTextIntrare.append(linie + "\n");
                }
                fisierIntrare.close();
            } catch (IOException ioe) {
                System.err.println("Eroare in fisierul: " + numeFisier + ": " + ioe.toString());
            }

        }
    }


}
