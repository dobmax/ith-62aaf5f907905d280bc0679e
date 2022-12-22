package ua.ithillel.lesson39.classwork.data.access;

import ua.ithillel.lesson39.classwork.entity.Country;

import java.util.Optional;

public interface CountryDaoService extends DaoService<Country> {
    @Override
    Iterable<Country> findAll();

    @Override
    Optional<Country> find(long id);

    @Override
    void add(Country obj);

    @Override
    void update(Country obj);

    @Override
    void remove(long id);
}
