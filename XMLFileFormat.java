import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLFileFormat extends FileFormat{
    DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder documentBuilder;
    Document document;

    XMLFileFormat(String ipfilename, String opfilename) {

        super(ipfilename, opfilename);
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void readFile() {
        try {

            File file = new File(getIpFileName());

            document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            // Get root element: CARDS
            Element root = document.getDocumentElement();

            //Get all cards nodes
            NodeList cardList = root.getElementsByTagName("CARD");

            for (int i = 0; i < cardList.getLength(); i++) {
                Node node = cardList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element cardElement = (Element) node;
                    String values = cardElement.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                    cardRecords.add(values);
                }
            }
        } catch (Exception e) {
            setExceptionRead(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    void writeFile() {
        try {
            document = documentBuilder.newDocument();

            // Create root element
            Element root = document.createElement("CARDS");
            document.appendChild(root);

            // Add array items as child elements
            for (CreditCard card: cards) {
                Element cardElement = document.createElement("CARD");
                Element cardNumberElement = document.createElement("CARD_NUMBER");
                cardNumberElement.appendChild(document.createTextNode(card.getCardNumber()));


                Element cardTypeElement = document.createElement("CARD_TYPE");
                cardTypeElement.appendChild(document.createTextNode(card.getCardType()));

                cardElement.appendChild(cardNumberElement);
                cardElement.appendChild(cardTypeElement);
                root.appendChild(cardElement);
            }

            // Write to XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new File(getOpFileName()));
            transformer.transform(source, result);

        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
