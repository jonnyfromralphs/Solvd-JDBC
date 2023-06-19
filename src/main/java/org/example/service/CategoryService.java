package org.example.service;

import org.example.dao.CategoryDAO;
import org.example.model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getById(id);
    }

    public void createCategory(Category category) {
        categoryDAO.create(category);
    }

    public void deleteCategory(int id) {
        categoryDAO.delete(id);
    }

    public void updateCategory(Category category, int id) {
        categoryDAO.update(category, id);
    }

}
