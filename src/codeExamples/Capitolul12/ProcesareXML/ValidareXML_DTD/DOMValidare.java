package codeExamples.Capitolul12.ProcesareXML.ValidareXML_DTD;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMValidare {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            MyErrorHandler err = new MyErrorHandler();
            builder.setErrorHandler(err);
            //crearea arborelui DOM
            Document doc = builder.parse("agenti_dtd.xml");
            //daca nu au fost semnnalate erori
            if(!err.isEroare()){
                System.out.println("OK");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Exceptie: " + e.getClass().getName() + e.getMessage());
        }
    }
}

class MyErrorHandler implements ErrorHandler {
    //declararea unei date private membre
    boolean eroare = false;

    boolean isEroare() { return eroare; }
    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("Avertisment: "+ e.getMessage());
        eroare = true;
    }

    public void error(SAXParseException e) throws SAXException {
        System.err.println("Eroare: " + e.getMessage());
        eroare = true;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("Eroare fatala: "+ exception.getMessage());
    }
}
