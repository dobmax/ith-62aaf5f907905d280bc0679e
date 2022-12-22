package ua.ithillel.lesson39.classwork.data.access.country;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.lesson39.classwork.data.access.CountryDaoService;
import ua.ithillel.lesson39.classwork.entity.Country;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class SimpleCountryDaoService implements CountryDaoService {

    private static final String FIND_ALL_QUERY = "SELECT id, name, mainland_id, mainland_name FROM country c " +
            "JOIN mainland m ON c.mainland_id = m.id";
    private static final String FIND_BY_ID_QUERY = "SELECT id, name, mainland_id, mainland_name FROM country c " +
            "JOIN mainland m ON c.mainland_id = m.id " +
            "WHERE c.id = ?";
    private static final String CREATE_QUERY = "INSERT INTO country (name, mainland_id) VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public SimpleCountryDaoService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Iterable<Country> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new CountryMapper());
    }

    @Override
    public Optional<Country> find(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new CountryMapper(), id));
    }

    @Override
    public void add(Country country) {
        jdbcTemplate.update(CREATE_QUERY, country.getName(), country.getMainland().getId());
    }

    @Override
    public void update(Country country) {
        // jdbcTemplate.update
    }

    @Override
    public void remove(long id) {
        // jdbcTemplate.update
    }
}
