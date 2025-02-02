package codeExamples.Cap12_ProcesareXML.E12_5_2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

class UtilClass {
    public void showAttributes( Node n) {
        NodeList aux;
        NamedNodeMap map;

        //Daca tag-ul are atribute atunci le vom afisa
        if (n.hasAttributes())
        {
            System.out.println("Atributele tag-ului " + n.getNodeName() + " sunt: ");
            //Obtinem lista atributelor
            map = n.getAttributes();
            //Parcurgem intreaga lista de atribute
            for(int i=0; i<map.getLength(); i++) {
                System.out.println("\t" + map.item(i).getNodeName() + "=\"" + map.item(i).getNodeValue() + "\"");
            }

            //Daca avem noduri descendente
            if(n.hasChildNodes())
            {
                aux = n.getChildNodes();
                //Parcurgem lista nodurilor descendente
                for(int i=0; i < aux.getLength(); i++)
                    //apel recursiv
                    showAttributes(aux.item(i));
            }
        }
    }
}

public class DOM02 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("optionale.xml");
            Element elt  = document.getDocumentElement();

            //Parcurgerea arborelui
            UtilClass util = new UtilClass();
            util.showAttributes(elt);

            //Prinderea exceptiilor
        } catch (ParserConfigurationException pce) {
            System.out.println("ParserConfigurationException: \n" + pce.getMessage());
        } catch (IOException ioe) {
            System.out.println("IOException: \n" + ioe.getMessage());
        } catch (SAXException se) {
            System.out.println("SAXException : \n" + se.getMessage());
        }
    }
}
