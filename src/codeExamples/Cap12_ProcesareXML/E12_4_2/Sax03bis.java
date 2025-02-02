package codeExamples.Cap12_ProcesareXML.E12_4_2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class MySAXHandler extends DefaultHandler {
    //se apeleaza atunci cand se ajunge la un tag XML
    public void startElement(String ns, String local, String name, Attributes atts)
            throws SAXException
    {
        //ne intereseaza doar tagul profesor
        if (local.equals("profesor"))
            System.out.println("NS: " + ns + "\nName: " + name);
    }

    //se apeleaza atunci cand intalneste o specificare a unui spatiu de nume
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException
    {
        System.out.println(">> Prefix: " + prefix + "\tURI: " + uri);
    }

    //se invoca atunci cand se iese din domeniul de valabilitate al respectivului
    //spatiu de nume
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println(">> End Prefix: " + prefix);
    }

    public void warning(SAXParseException spe) throws SAXException {
        System.out.println("Warning: " + spe.getMessage());
    }

    public void error(SAXParseException spe) throws SAXException {
        String message = "Error: " + spe.getMessage();
        throw new SAXException(message);
    }

    public void fatalError(SAXParseException spe) throws SAXException {
        String message = "Fatal Error: " + spe.getMessage();
        throw new SAXException(message);
    }
}

public class Sax03bis {
    public static void main(String[] args) {

        //========CAZ INITIAL FARA SPECIFICATIE DTD===========
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        DefaultHandler handler = new MySAXHandler();
//        SAXParser parser;
//
//        //se invoca procesarea spatiilor de nume
//        factory.setNamespaceAware(true);
//
//        try {
//            parser = factory.newSAXParser();
//            parser.parse("optionale_ns.xml", handler);
//        } catch (ParserConfigurationException pce) {
//            System.err.println("ParserConfigurationException:\n" + pce.getMessage());
//        } catch (SAXException se) {
//            System.out.println("SAXException:\n" + se.getMessage());
//        } catch (IOException ioe) {
//            System.err.println("IOException:\n" + ioe.getMessage());
//        }

        //=========CAZ IN CARE EXISTA UN DOCUMENT DTD CU SPECIFICATII DE STRUCTURA
        SAXParserFactory factory = SAXParserFactory.newInstance();
        DefaultHandler handler = new MySAXHandler();
        SAXParser parser;
        XMLReader xmlReader;


        factory.setValidating(true);
        try {
            parser = factory.newSAXParser();
            xmlReader = parser.getXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.setErrorHandler(handler);
            xmlReader.parse("optionale_ns.xml");
        } catch (ParserConfigurationException pce) {
            System.err.println("ParserConfigurationException:\n" + pce.getMessage());
        } catch (SAXException se) {
            System.out.println("SAXException:\n" + se.getMessage());
        } catch (IOException ioe) {
            System.err.println("IOException:\n" + ioe.getMessage());
        }
    }

}
