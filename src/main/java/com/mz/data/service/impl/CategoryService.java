package com.mz.data.service.impl;

import com.mz.data.dao.CategoryRepository;
import com.mz.data.model.Category;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CategoryService extends GenericService<Category , Integer> implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    protected JpaRepository<Category, Integer> jpaRepository() {
        return categoryRepository;
    }

    @Override
    public void save(Category entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Category entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }
}
