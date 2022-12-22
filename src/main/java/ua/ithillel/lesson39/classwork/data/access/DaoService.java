package ua.ithillel.lesson39.classwork.data.access;

import java.util.Optional;

/**
 * @param <T> represents a real data type of the database object
 */
public interface DaoService<T> {
    Iterable<T> findAll();
    Optional<T> find(long id);
    void add(T obj);
    void update(T obj);
    void remove(long id);
}
