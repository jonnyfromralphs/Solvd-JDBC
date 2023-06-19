package org.example.service;

import org.example.dao.ProductDAO;
import org.example.model.Product;
import org.example.model.User;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public Product getProductrById(int id) {
        return productDAO.getById(id);
    }

    public void createProduct(Product product) {
        productDAO.create(product);
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }

    public void updateProduct(Product product, int id) {
        productDAO.update(product, id);
    }

    public int getProductId(Product product) {
        return productDAO.getProductId(product);
    }

}
