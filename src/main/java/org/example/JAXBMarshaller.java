package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.example.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class JAXBMarshaller {
    public static void main(String[] args) {
        try {
            File userXML = new File("src/main/resources/User.xml");

            JAXBContext userContext = JAXBContext.newInstance(User.class);
            Unmarshaller userUnmarshaller = userContext.createUnmarshaller();

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document userDoc = db.parse(userXML);
            NodeList userNodeList = userDoc.getElementsByTagName("user");

            for (int i = 0; i < userNodeList.getLength(); i++) {
                Node node = userNodeList.item(i);
                User user = (User) userUnmarshaller.unmarshal(node);
                System.out.println(user.toString());
            }

            File productXML = new File("src/main/resources/Product.xml");

            JAXBContext productContext = JAXBContext.newInstance(Product.class);
            Unmarshaller productUnmarshaller = productContext.createUnmarshaller();

            Document productDoc = db.parse(productXML);
            NodeList productNodeList = productDoc.getElementsByTagName("product");

            for (int i = 0; i < productNodeList.getLength(); i++) {
                Node node = productNodeList.item(i);
                Product product = (Product) productUnmarshaller.unmarshal(node);
                System.out.println(product.toString());
            }

            File addressXML = new File("src/main/resources/Address.xml");

            JAXBContext addressContext = JAXBContext.newInstance(Address.class);
            Unmarshaller addressUnmarshaller = addressContext.createUnmarshaller();

            Document addressDoc = db.parse(addressXML);
            NodeList addressNodeList = addressDoc.getElementsByTagName("address");

            for (int i = 0; i < addressNodeList.getLength(); i++) {
                Node node = addressNodeList.item(i);
                Address address = (Address) addressUnmarshaller.unmarshal(node);
                System.out.println(address.toString());
            }

            File categoryXML = new File("src/main/resources/Category.xml");

            JAXBContext categoryContext = JAXBContext.newInstance(Category.class);
            Unmarshaller categoryUnmarshaller = categoryContext.createUnmarshaller();

            Document categoryDoc = db.parse(categoryXML);
            NodeList categoryNodeList = categoryDoc.getElementsByTagName("category");

            for (int i = 0; i < categoryNodeList.getLength(); i++) {
                Node node = categoryNodeList.item(i);
                Category category = (Category) categoryUnmarshaller.unmarshal(node);
                System.out.println(category.toString());
            }

            File reviewXML = new File("src/main/resources/Review.xml");

            JAXBContext reviewContext = JAXBContext.newInstance(Review.class);
            Unmarshaller reviewUnmarshaller = reviewContext.createUnmarshaller();

            Document reviewDoc = db.parse(reviewXML);
            NodeList reviewNodeList = reviewDoc.getElementsByTagName("review");

            for (int i = 0; i < reviewNodeList.getLength(); i++) {
                Node node = reviewNodeList.item(i);
                Review review = (Review) reviewUnmarshaller.unmarshal(node);
                System.out.println(review.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
