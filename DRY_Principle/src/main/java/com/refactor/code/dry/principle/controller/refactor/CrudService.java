package com.refactor.code.dry.principle.controller.refactor;

import java.util.List;

public interface CrudService<T, ID> {

    List<T> getAll();

    T getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);
}