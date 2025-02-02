package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.Citiri.Citiri_Fisier_StringTokenizer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CautareFisier extends Frame implements ActionListener {
    //declararea datelor membre
    private Button butonCautare;
    private TextField rezultat1;
    private TextField rezultat2;
    private TextField campPersoana;
    private TextField campNumeFisier;

    public static void main(String[] args) {
        CautareFisier f = new CautareFisier();
        f.setBounds(200, 100, 400, 150);
        f.interfataGrafica();
        f.setTitle("Cautare in fisier");
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == butonCautare) {
            String numeFisier = campNumeFisier.getText();
            BufferedReader fisierIntrare = null;
            try {
                fisierIntrare = new BufferedReader(new FileReader(numeFisier));
            } catch (IOException ioe) {
                System.err.println("Nu gasim fisierul: " + numeFisier + ": " + ioe.toString());
                return;
            }

            try {
                String linie;
                boolean gasit = false;
                while (((linie = fisierIntrare.readLine()) != null) && (!gasit)) {
                    StringTokenizer tokens = new StringTokenizer(linie, " ,");
                    String numeFisierIntrare = tokens.nextToken();
                    if (campPersoana.getText().equals(numeFisierIntrare)) {
                        gasit = true;
                        rezultat1.setText(tokens.nextToken());
                        rezultat2.setText(tokens.nextToken());
                    }
                }
                fisierIntrare.close();
            } catch (IOException e) {
                System.err.println("Eroare in fisierul: " + numeFisier + ": " + e.toString());
                System.exit(1);
            }
        }
    }

    public void interfataGrafica() {
        setLayout(new FlowLayout());
        Label eticheta = new Label("Dati numele fisierului: ");
        add(eticheta);
        campNumeFisier = new TextField(20);
        campNumeFisier.setText("");
        add(campNumeFisier);
        butonCautare = new Button(" Cautare ");
        add(butonCautare);
        butonCautare.addActionListener(this);
        add(new Label("Numele: "));
        campPersoana = new TextField(20);
        campPersoana.setText("");
        add(campPersoana);
        add(new Label("Nota 1:"));
        rezultat1 = new TextField(5);
        rezultat1.setEditable(false);
        add(rezultat1);
        add(new Label("Nota 2: "));
        rezultat2 = new TextField(5);
        rezultat2.setEditable(false);
        add(rezultat2);
        //pentru inchiderea ferestrei
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                    System.exit(0);
                };
            });
    }
}
