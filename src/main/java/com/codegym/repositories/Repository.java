package com.codegym.repositories;

import java.util.List;

public interface Repository<T> {
    T findById(Long id);
    List<T> findAll();
    boolean save(T t);
    boolean delete(Long id);
}
