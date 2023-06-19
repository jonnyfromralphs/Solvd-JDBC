package org.example.dao;

import java.util.List;

public interface IDAO<T> {
    void create(T object);
    void update(T object, int id);
    void delete(int id);
    T getById(int id);
    List<T> getAll();
}
