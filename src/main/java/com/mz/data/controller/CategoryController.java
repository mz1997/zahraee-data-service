package com.mz.data.controller;


import com.mz.data.loadView.CategoryLoad;
import com.mz.data.model.Category;
import com.mz.data.model.Pagination;
import com.mz.data.postView.CategoryPost;
import com.mz.data.service.interfaces.ICategoryService;
import com.mz.data.view.CategoryView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {



    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody CategoryPost categoryPost) {
        Category category = mapper.map(categoryPost ,Category.class);
        if (categoryPost.getId()!= null){
            throw new RuntimeException();
        }
        categoryService.save(category);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody CategoryPost categoryPost) {
        Category category = mapper.map(categoryPost ,Category.class);
        if (categoryPost.getId()== null){
            throw new RuntimeException();
        }
        categoryService.edit(category);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public CategoryLoad load(@PathVariable Integer id) {
        return convert(categoryService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
    public List<CategoryLoad> getAll() {
        List<Category> listCategory = new ArrayList<Category>();
        listCategory = categoryService.getAll();
        List<CategoryLoad> list =  new ArrayList<CategoryLoad>();
        for(Category categoryFor : listCategory)
        {
            list.add(convert(categoryFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<CategoryLoad> search(@RequestBody(required = false) CategoryView categoryView){
        Category category = mapper.map(categoryView ,Category.class);
        Page<Category> temps = categoryService.findAll(categoryView.getPage(), categoryView.getSize() , category);
        List<Category> listCategory = temps.getContent();
        List<CategoryLoad> list =  new ArrayList<CategoryLoad>();
        for(Category categoryFor : listCategory)
        {
            list.add(convert(categoryFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private CategoryLoad convert(Category category)
    {
        CategoryLoad retuenValue =  mapper.map(category ,CategoryLoad.class);
        return retuenValue;
    }
}
