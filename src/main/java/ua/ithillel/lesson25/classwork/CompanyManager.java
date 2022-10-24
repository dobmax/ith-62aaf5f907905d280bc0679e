package ua.ithillel.lesson25.classwork;

import java.util.List;
import java.util.Optional;

/**
 * @param <T> - type of managing
 */
public interface CompanyManager<T> {
    List<T> findAllAssigned();

    List<T> findAssigned(long... ids);

    Optional<T> findAssigned(long id);
}
