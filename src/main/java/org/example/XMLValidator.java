package org.example;

import org.example.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLValidator {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        File userSchemaFile = new File("src/main/resources/User.xsd");
        File userXMLFile = new File("src/main/resources/User.xml");
        Source userXMLSource = new StreamSource("src/main/resources/User.xml");

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema userSchema = factory.newSchema(userSchemaFile);
        Validator userSchemaValidator = userSchema.newValidator();
        userSchemaValidator.validate(userXMLSource);

        File reviewSchemaFile = new File("src/main/resources/Review.xsd");
        File reviewXMLFile = new File("src/main/resources/Review.xml");
        Source reviewXMLSource = new StreamSource("src/main/resources/Review.xml");

        Schema reviewSchema = factory.newSchema(reviewSchemaFile);
        Validator reviewSchemaValidator = reviewSchema.newValidator();
        reviewSchemaValidator.validate(reviewXMLSource);

        File productSchemaFile = new File("src/main/resources/Product.xsd");
        File productXMLFile = new File("src/main/resources/Product.xml");
        Source productXMLSource = new StreamSource("src/main/resources/Product.xml");

        Schema productSchema = factory.newSchema(productSchemaFile);
        Validator productSchemaValidator = productSchema.newValidator();
        productSchemaValidator.validate(productXMLSource);

        File categorySchemaFile = new File("src/main/resources/Category.xsd");
        File categoryXMLFile = new File("src/main/resources/Category.xml");
        Source categoryXMLSource = new StreamSource("src/main/resources/Category.xml");

        Schema categorySchema = factory.newSchema(categorySchemaFile);
        Validator categorySchemaValidator = categorySchema.newValidator();
        categorySchemaValidator.validate(categoryXMLSource);

        File addressSchemaFile = new File("src/main/resources/Address.xsd");
        File addressXMLFile = new File("src/main/resources/Address.xml");
        Source addressXMLSource = new StreamSource("src/main/resources/Address.xml");

        Schema addressSchema = factory.newSchema(addressSchemaFile);
        Validator addressSchemaValidator = addressSchema.newValidator();
        addressSchemaValidator.validate(addressXMLSource);

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document userDoc = db.parse(userXMLFile);
        NodeList userNodeList = userDoc.getElementsByTagName("user");

        System.out.println("Parsing user xml");
        System.out.println();
        for (int i = 0; i < userNodeList.getLength(); i++) {

            Node userNode = userNodeList.item(i);
            Element userElement = (Element) userNode;

            int id = Integer.parseInt(userElement.getElementsByTagName("id").item(0).getTextContent());
            String username = userElement.getElementsByTagName("username").item(0).getTextContent();
            String email = userElement.getElementsByTagName("email").item(0).getTextContent();
            String password = userElement.getElementsByTagName("password").item(0).getTextContent();
            String registrationDate = userElement.getElementsByTagName("registration_date").item(0).getTextContent();

            System.out.println("User ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Registration Date: " + registrationDate);
            System.out.println();
        }

        Document reviewDoc = db.parse(reviewXMLFile);
        NodeList reviewNodeList = reviewDoc.getElementsByTagName("review");

        System.out.println("Parsing review xml");
        System.out.println();
        for (int i = 0; i < reviewNodeList.getLength(); i++) {
            Node reviewNode = reviewNodeList.item(i);
            Element reviewElement = (Element) reviewNode;

            double rating = Double.parseDouble(reviewElement.getElementsByTagName("rating").item(0).getTextContent());
            String comment = reviewElement.getElementsByTagName("comment").item(0).getTextContent();

            System.out.println("Rating: " + rating);
            System.out.println("Comment: " + comment);
            System.out.println();
        }

        Document productDoc = db.parse(productXMLFile);
        NodeList productNodeList = productDoc.getElementsByTagName("product");

        System.out.println("Parsing product xml");
        System.out.println();
        for (int i = 0; i < productNodeList.getLength(); i++) {
            Node productNode = productNodeList.item(i);
            Element productElement = (Element) productNode;

            String name = productElement.getElementsByTagName("name").item(0).getTextContent();
            String description = productElement.getElementsByTagName("description").item(0).getTextContent();
            double price = Double.parseDouble(productElement.getElementsByTagName("price").item(0).getTextContent());
            int stockQuantity = Integer.parseInt(productElement.getElementsByTagName("stock_quantity").item(0).getTextContent());

            System.out.println("Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Price: " + price);
            System.out.println("Stock: " + stockQuantity);
            System.out.println();
        }

        Document categoryDoc = db.parse(categoryXMLFile);
        NodeList categoryNodeList = categoryDoc.getElementsByTagName("category");

        System.out.println("Parsing category xml");
        System.out.println();
        for (int i = 0; i < categoryNodeList.getLength(); i++) {
            Node categoryNode = categoryNodeList.item(i);
            Element categoryElement = (Element) categoryNode;

            String name = categoryElement.getElementsByTagName("name").item(0).getTextContent();
            String description = categoryElement.getElementsByTagName("description").item(0).getTextContent();

            System.out.println("Category Name: " + name);
            System.out.println("Description: " + description);
            System.out.println();
        }

        Document addressDoc = db.parse(addressXMLFile);
        NodeList addressNodeList = addressDoc.getElementsByTagName("address");

        System.out.println("Parsing address xml");
        System.out.println();
        for (int i = 0; i < addressNodeList.getLength(); i++) {
            Node addressNode = addressNodeList.item(i);
            Element addressElement = (Element) addressNode;

            String addressLineOne = addressElement.getElementsByTagName("address_line1").item(0).getTextContent();
            String addressLineTwo = addressElement.getElementsByTagName("address_line2").item(0).getTextContent();
            String city = addressElement.getElementsByTagName("city").item(0).getTextContent();
            String state = addressElement.getElementsByTagName("state").item(0).getTextContent();
            String zipCode = addressElement.getElementsByTagName("zip_code").item(0).getTextContent();

            System.out.println("Address Line 1: " + addressLineOne);
            System.out.println("Address Line 2: " + addressLineTwo);
            System.out.println("City: " + city);
            System.out.println("State: " + state);
            System.out.println("Zip Code: " + zipCode);
            System.out.println();
        }
    }
}
