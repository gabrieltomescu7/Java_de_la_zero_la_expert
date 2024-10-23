package codeExamples.CapitolulPatru.StructuriDinamice.Properties.E4_3_15;

import java.util.Iterator;
import java.util.Properties;

public class ListaProprietati {
    public static void main(String[] args) {
        Properties prop = new Properties();

        //adaugam cateva asocieri
        prop.setProperty("unu", "1");
        prop.setProperty("doi", "2");
        prop.setProperty("trei", "3");
        prop.setProperty("patru", "4");
        prop.setProperty("cinci", "5");

        //parcurgem multimea de chei
        Iterator<String> it = prop.stringPropertyNames().iterator();
        while(it.hasNext()) {
            String cheieProp = it.next();
            System.out.println(cheieProp + " = " + prop.getProperty(cheieProp));
        }
    }
}
