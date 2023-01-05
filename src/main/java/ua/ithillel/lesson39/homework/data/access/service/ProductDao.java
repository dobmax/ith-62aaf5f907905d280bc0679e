package ua.ithillel.lesson39.homework.data.access.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.lesson39.homework.data.access.entity.Product;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao implements DaoService<Product> {

    private static final String CREATE_QUERY = "INSERT INTO products (name, price) VALUES (?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM products WHERE id = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT id, name, price FROM products WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT id, name, price FROM products";

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void create(Product product) {
        jdbcTemplate.update(CREATE_QUERY, product.getName(), product.getPrice());
    }

    @Override
    @Transactional
    public void delete(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, Product.class));
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new ProductMapper());
    }

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            var product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getFloat("price"));

            return product;
        }
    }

}
