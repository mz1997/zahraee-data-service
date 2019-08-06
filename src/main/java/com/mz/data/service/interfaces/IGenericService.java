package com.mz.data.service.interfaces;

import com.mz.data.model.BaseEntity;
import com.mz.data.model.Pagination;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T extends BaseEntity<PK>, PK extends Serializable> {


    void save(T entity);

    T load(PK id);

    void delete(PK id);

    void edit(T entity);

    List<T> getAll();

    <S extends T> Page<T> findAll(int page, int size, S example);
}
