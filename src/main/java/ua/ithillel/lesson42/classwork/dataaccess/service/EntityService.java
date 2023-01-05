package ua.ithillel.lesson42.classwork.dataaccess.service;

import java.util.Optional;

public interface EntityService<T> {
    Optional<T> findById(long id);
}
