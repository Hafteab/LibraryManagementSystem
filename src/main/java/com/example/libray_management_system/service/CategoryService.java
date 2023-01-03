package com.example.libray_management_system.service;


import com.example.libray_management_system.entity.Category;
import com.example.libray_management_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategorys(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category NOt found"));
        return category;
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category NOt found"));
        categoryRepository.deleteById(category.getId());
    }

}
