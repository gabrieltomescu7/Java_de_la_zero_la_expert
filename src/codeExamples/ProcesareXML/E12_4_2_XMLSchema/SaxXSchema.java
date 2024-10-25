package codeExamples.ProcesareXML.E12_4_2_XMLSchema;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


class MySAXHandler extends DefaultHandler {

    private int flag;
    //se apeleaza la inceputul documentului
    public void startDocument() throws SAXException {
        System.out.println("Cursurile optionale sunt:");
    }

    //se apeleaza atunci cand se ajunge la un tag XML
    public void startElement(String ns, String local, String name, Attributes atts)
            throws SAXException
    {
        //ne intereseaza doar tagul profesor
        if (name.equals("nume"))
            flag = 1;
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
//    //se apeleaza atunci cand intalneste o specificare a unui spatiu de nume
//    public void startPrefixMapping(String prefix, String uri)
//            throws SAXException
//    {
//        System.out.println(">> Prefix: " + prefix + "\tURI: " + uri);
//    }
//
//    //se invoca atunci cand se iese din domeniul de valabilitate al respectivului
//    //spatiu de nume
//    public void endPrefixMapping(String prefix) throws SAXException {
//        System.out.println(">> End Prefix: " + prefix);
//    }

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


public class SaxXSchema {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);
        DefaultHandler handler = new MySAXHandler();
        SAXParser parser;

        try {
            parser = factory.newSAXParser();
            parser.setProperty(
                    "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                    "http://www.w3.org/2001/XMLSchema"
            );
            parser.parse("optionale.xml", handler);
        } catch (SAXNotRecognizedException snr) {
            System.out.println("SAXNotRecognizedException: \n" + snr.getMessage());
        } catch (ParserConfigurationException pce) {
            System.out.println("PasrserConfigurationException:\n" + pce.getMessage());
        } catch (SAXNotSupportedException e) {
            throw new RuntimeException(e);
        } catch (SAXException se) {
            System.out.println("SAXException:\n" + se.getMessage());
        } catch (IOException ioe) {
            System.out.println("IOException:\n" + ioe.getMessage());
        }
    }
}
