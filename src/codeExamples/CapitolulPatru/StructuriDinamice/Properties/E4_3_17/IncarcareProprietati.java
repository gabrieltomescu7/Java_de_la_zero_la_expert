package codeExamples.CapitolulPatru.StructuriDinamice.Properties.E4_3_17;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class IncarcareProprietati {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty("buffSize", "512");
        props.setProperty("maxUsers", "20");

        try {
            FileInputStream fluxIn = new FileInputStream("config.ini");
            props.load(fluxIn);
            fluxIn.close();
        } catch (IOException e ) {
            e.printStackTrace();
        }
        props.list(System.out);
    }
}
