package codeExamples.Capitolul12.ProcesareXML.ProcesareSpatiiNume;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMSpatiiNume {
    //Definirea unei metode private pentru procesare informatiilor din arbore
    private static void procesare(Node nod) {
        //afisare mesaj la consola
        if (nod.getPrefix() != null || nod.getNamespaceURI() != null)
            System.out.println("NS: " + nod.getPrefix() + " " + nod.getNamespaceURI());
        System.out.println(nod.getNodeName() + " " + nod.getNodeValue());


                //DACA ARE ATRIBUTE
                if (nod.hasAttributes()) {
                NamedNodeMap atts = nod.getAttributes();
                for( int i = 0; i < atts.getLength(); i++ )
                    procesare(atts.item(i));
                }
        //DACA ARE DESCENDENTI
        if (nod.hasChildNodes()) {
            NodeList desc = nod.getChildNodes();
            Node n;
            for(int i = 0; i < desc.getLength(); i++) {
                n = desc.item(i);
                // ne intereseaza doar descendentii de tip element
                if(n.getNodeType() == n.ELEMENT_NODE)
                    procesare(n);
            }
        }
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Indicam faptul ca utilizam spatii de nume
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            //crearea arborelui dom
            Document doc = builder.parse("spatii.xml");
            procesare(doc.getDocumentElement());
        } catch (ParserConfigurationException pce) {
            System.err.println("ParserConfigurationException: \n" + pce.getMessage());
        } catch (IOException ioe) {
            System.err.println("IOException: \n" + ioe.getMessage());
        } catch (SAXException se) {
            System.err.println("SAXException: \n" + se.getMessage());
        }
    }
}
