package codeExamples.Capitolul12.ProcesareXML.E12_4_2_XML_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM01 {
    public static void main(String[] args) {

        DocumentBuilder builder;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();

            //Obtinerea arborelui asociat
            Document document = builder.parse("optionale.xml");

            //Obtinerea elementului radacina
            Element elt = document.getDocumentElement();
            Node opt, n;
            System.out.println("Elementul radacina este: " + elt.getTagName());

            //Parcurgerea arborelui
            System.out.println("Cursurile optionale sunt: ");

            //Daca elementul-radacina nu contine elemente afisez un mesaj de eroare.
            if (!elt.hasChildNodes()) {
                System.err.println("Radacina trebuie sa contina subelemente");
                System.exit(1);
            }

            //Obtin nodul corespunzator primului optional
            opt = elt.getFirstChild();

            //Cat timp mai am optionale neprocesate
            while(opt != null)
            {
                // Parcurgerea nodurilor descendente
                n = opt.getFirstChild();
                while(n != null)
                    //Daca am ajuns la nodul corespunzator tagului nume
                    if(n.getNodeName().equals("nume"))
                    {
                        n = n.getFirstChild();
                        System.out.println(" * ");
                        while(n != null)
                        {
                            //Afisez textul din interiorul tagului nume
                            if (n.getNodeType() == Node.TEXT_NODE)
                                System.out.println(n.getNodeValue().trim());
                            //trec la urmatorul nod din lista nodurilor descendente
                            n = n.getNextSibling();
                        }
                        n = null; // iesire fortata din while
                    }
                    else
                        n = n.getNextSibling();
                    opt= opt.getNextSibling();
            }
            //Prinderea exceptiilor
        } catch (ParserConfigurationException pce) {
            System.out.println("ParserConfigurationException:\n" + pce.getMessage());
        } catch (IOException ioe) {
            System.out.println("IOException:\n" + ioe.getMessage());
        } catch (SAXException se) {
            System.out.println("SAXException:\n" + se.getMessage());
        }
    }
}
