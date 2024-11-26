package codeExamples.Capitolul12.ProcesareXML.E12_4_1;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class MySAXHandler extends DefaultHandler {
    //indicator pt a stabili care informatie cuprinsa intre taguri va fi afisata pe ecran
    private int flag;

    public MySAXHandler() { flag = 0;}

    public void startDocument() throws SAXException {
        System.out.println("Cursurile optionale sunt:");
    }

    public void startElement(String ns, String local, String name, Attributes atts) throws SAXException {
        if (name.equals("nume")) flag = 1;
        //Obtinerea valorilor atributelor unui tag
//        else if( name.equals("studenti"))
//        {
//            String min = atts.getValue("min");
//            String max = atts.getValue("max");
//            if (min != null) // daca exista atributul min
//                System.out.println("\tNumarul minim de studenti: " + min);
//            if (max != null) // daca exista atributul max
//                System.out.println("\tNumarul maxim de studenti: " + max);
//        }
        //Afisarea tuturor atributelor tagului studenti
        else if (name.equals("studenti")) {
            for(int i = 0; i < atts.getLength(); i++)
                System.out.println("\t" + atts.getQName(i) + " = " + atts.getValue(i));
        }

    }


    public void endElement( String ns, String local, String name) throws SAXException {
        if (name.equals("nume")) flag = 0;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if( flag == 1 )
        {
            System.out.print(" * ");
            for( int i = 0; i < length; i++)
                System.out.print(ch[start+i]);
            System.out.println("");
        }
    }
}
public class Sax01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        DefaultHandler handler = new MySAXHandler();
        SAXParser parser;

        try {
            parser = factory.newSAXParser();
            parser.parse("optionale.xml", handler);
        } catch (SAXException se) {
            System.err.println("SAXException:\n" + se.getMessage());
        } catch (IOException ioe) {
            System.err.println("IOException:\n" + ioe.getMessage());
        } catch (ParserConfigurationException pce) {
            System.err.println("ParserConfigurationException:\n" + pce.getMessage());
        }
    }
}
