package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.*;

import java.io.File;
import java.io.IOException;

public class JSONParser {
    private static final Logger logger = LogManager.getLogger(JSONParser.class);

    public static void main(String[] args) {
        File jsonFile = new File("src/main/resources/WebStore.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            JsonNode userNode = rootNode.get("users");
            for (JsonNode node : userNode) {
                User user = objectMapper.treeToValue(node, User.class);
                logger.info(user.getUsername());
                logger.info(user.getEmail());
                logger.info(user.getPassword());
                logger.info(user.getRegistrationDate());
                logger.info(user.getAddresses());
            }

            JsonNode reviewNode = rootNode.get("reviews");
            for (JsonNode node : reviewNode) {
                Review review = objectMapper.treeToValue(node, Review.class);
                logger.info(review.getRating());
                logger.info(review.getComment());
            }

            JsonNode categoryNode = rootNode.get("categories");
            for (JsonNode node : categoryNode) {
                Category category = objectMapper.treeToValue(node, Category.class);
                logger.info(category.getName());
                logger.info(category.getDescription());
            }

            JsonNode productNode = rootNode.get("products");
            for (JsonNode node : productNode) {
                Product product = objectMapper.treeToValue(node, Product.class);
                logger.info(product.getName());
                logger.info(product.getDescription());
                logger.info(product.getPrice());
                logger.info(product.getStockQuantity());
            }

            JsonNode addressNode = rootNode.get("addresses");
            for (JsonNode node : addressNode) {
                Address address = objectMapper.treeToValue(node, Address.class);
                logger.info(address.getAddressLineOne());
                logger.info(address.getAddressLineTwo());
                logger.info(address.getCity());
                logger.info(address.getState());
                logger.info(address.getZipCode());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
