package xmlQuestion;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFIle {
    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File inputFile = new File("data.xml");
            org.w3c.dom.Document document = builder.parse(inputFile);

            document.getDocumentElement().normalize();
            
            NodeList contactBook = document.getElementsByTagName("contact");

            for(int i=0;i<contactBook.getLength();i++)
            {
                Node newContact = contactBook.item(i);
                System.out.println("Name: "+newContact.getAttributes().getNamedItem("id").getNodeValue());

                Element element = (Element) newContact;

                System.out.print("Primary Number: "+element.getElementsByTagName("primaryNumber").item(0).getTextContent());
                System.out.print(", Secondary Number: "+element.getElementsByTagName("secondaryNumber").item(0).getTextContent());
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
