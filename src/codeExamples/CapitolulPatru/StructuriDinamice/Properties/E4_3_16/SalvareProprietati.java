package codeExamples.CapitolulPatru.StructuriDinamice.Properties.E4_3_16;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SalvareProprietati {
    public static void main(String[] args) {
        Properties config = new Properties();

        config.setProperty("port", "9090");
        config.setProperty("maxUsers", "100");
        config.setProperty("maxMsgSize", "2048");

        FileOutputStream fluxOut = null;

        try {
            fluxOut = new FileOutputStream("config.ini");
            config.store(fluxOut,  "Fisier de configurare");
            fluxOut.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
