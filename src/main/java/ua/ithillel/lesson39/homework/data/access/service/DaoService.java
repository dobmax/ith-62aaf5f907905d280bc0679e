package ua.ithillel.lesson39.homework.data.access.service;

import java.util.List;
import java.util.Optional;

public interface DaoService<T> {
    void create(T obj);
    void delete(long id);
    Optional<T> findById(long id);
    List<T> findAll();
}
