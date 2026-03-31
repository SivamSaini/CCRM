package edu.ccrm.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    T create(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    T update(T entity);
    void delete(ID id);
    boolean exists(ID id);
}