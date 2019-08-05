package com.mz.data.controller;


import com.mz.data.model.Category;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.ICategoryService;
import com.mz.data.view.CategoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Category category) {
        categoryService.save(category);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Category load(@PathVariable Integer id) {
        return categoryService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Category category) {
        categoryService.edit(category);
    }

    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Category> save(@RequestBody CategoryView categoryView){
        Category category = new Category();
        category.setName(categoryView.getName());
        category.setlUpdate(categoryView.getlUpdate());
        return categoryService.findAll(categoryView.getPage(),categoryView.getSize() , category);
    }
}
