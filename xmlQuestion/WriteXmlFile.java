package xmlQuestion;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class WriteXmlFile {

    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File inputFile = new File("data.xml");
            org.w3c.dom.Document document = builder.parse(inputFile);
            
            Element root = document.createElement("contact");
            document.appendChild(root);
            root.setAttribute("id", "ram");

            Element primaryNumber = document.createElement("primaryNumber");
            primaryNumber.setTextContent("9090909090");
            Element secondaryNumber = document.createElement("secondaryNumber");
            secondaryNumber.setTextContent("08880808");

            root.appendChild(primaryNumber);
            root.appendChild(secondaryNumber);

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transform = transFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult("newdata.xml");
            transform.transform(source, result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
