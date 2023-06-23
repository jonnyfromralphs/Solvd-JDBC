package org.example.mapper;

import org.example.model.Category;

public interface CategoryMapper {
    Category selectCategoryById(int id);
    void addCategory(Category category);
    void deleteCategory(int id);
    int getIdByCategory(String name);
    void updateCategory(Category category);
}
