package codeExamples.CapitolulPatru_Siruri_StructuriDinamice.StructuriDinamice.Properties.E4_3_18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.Properties;

public class SalvareProprietatiXML {
    public static void main(String[] args) {
        Properties config = new Properties();
        config.setProperty("timeout", "5000");
        config.setProperty("helloMsg", "Hello!");

        FileOutputStream fluxOut = null;

        try {
            fluxOut = new FileOutputStream("config.xml");
            config.storeToXML(fluxOut, "Fisier de configurare");
            fluxOut.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        BitSet set = new BitSet();

        String data = "abcd";
        char e = data.toCharArray()[0];
        System.out.println(e);
        String ana = data.toString().toString().toString();

        
    }
}
