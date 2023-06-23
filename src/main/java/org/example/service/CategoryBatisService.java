package org.example.service;

import org.example.mapper.CategoryMapper;
import org.example.model.Category;

public class CategoryBatisService {
    private CategoryMapper categoryMapper;
    public CategoryBatisService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Category selectCategoryById(int id) {
        return categoryMapper.selectCategoryById(id);
    }

    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    public void deleteCategory(int id) {
        categoryMapper.deleteCategory(id);
    }

    public int getIdByCategory(String name) {
        return categoryMapper.getIdByCategory(name);
    }

    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }
}
