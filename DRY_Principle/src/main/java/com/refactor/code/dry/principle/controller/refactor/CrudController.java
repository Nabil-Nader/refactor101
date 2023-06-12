package com.refactor.code.dry.principle.controller.refactor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

public abstract class CrudController<T, ID> {

     abstract  CrudService<T, ID> getService();


    @GetMapping("/")
    public List<T> getAll() {
        return getService().getAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        return getService().getById(id);
    }

    @PostMapping("/")
    public T create(@RequestBody T entity) {
        return getService().create(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        return getService().update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

}

