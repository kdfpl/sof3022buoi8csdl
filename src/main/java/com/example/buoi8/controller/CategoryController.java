package com.example.buoi8.controller;

import com.example.buoi8.entity.Category;
import com.example.buoi8.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listCT", categoryService.getAll());
        model.addAttribute("ct", new Category());
        return "hien-thi";
    }

    @GetMapping("/remove/{id}")
    public String xoa(@PathVariable Long id) {
        categoryService.remove(id);
        return "redirect:/hien-thi";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("ct") Category category) {
        categoryService.add(category);
        return "redirect:/hien-thi";
    }
}
