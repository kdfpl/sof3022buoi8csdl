package com.example.buoi8.service;

import com.example.buoi8.entity.Category;
import com.example.buoi8.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll() {
        return repository.findAll();
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public void add(Category category) {
        repository.save(category);
    }
}
