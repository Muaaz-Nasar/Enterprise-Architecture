import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.File;

public class XmlModifier {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("books.xml");
            document.getDocumentElement().normalize();

            // Modify the year of the first book
            NodeList nodeList = document.getElementsByTagName("book");
            Element firstBook = (Element) nodeList.item(0);
            firstBook.getElementsByTagName("year").item(0).setTextContent("2023");

            // Save the modified document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("updated_books.xml"));
            transformer.transform(source, result);

            System.out.println("XML file updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
