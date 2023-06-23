package org.example.mapper;

import org.example.model.Product;

public interface ProductMapper {
    Product selectProductById(int id);
    void addProduct(Product product);
    void deleteProduct(int id);
    int getIdByProductName(String name);
    void updateProduct(Product product);

}
