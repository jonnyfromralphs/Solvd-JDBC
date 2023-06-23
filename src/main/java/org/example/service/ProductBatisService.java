package org.example.service;

import org.example.mapper.ProductMapper;
import org.example.model.Product;

public class ProductBatisService {
    private ProductMapper productMapper;

    public ProductBatisService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Product selectProductById(int id) {
        return productMapper.selectProductById(id);
    }

    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    public void deleteProduct(int id) {
        productMapper.deleteProduct(id);
    }

    public int getIdByProductName(String name) {
        return productMapper.getIdByProductName(name);
    }

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }
}
