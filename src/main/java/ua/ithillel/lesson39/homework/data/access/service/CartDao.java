package ua.ithillel.lesson39.homework.data.access.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import ua.ithillel.lesson39.homework.data.access.entity.Cart;
import ua.ithillel.lesson39.homework.data.access.entity.Product;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CartDao implements DaoService<Cart> {

    private static final String CREATE_QUERY = "INSERT INTO carts (name) VALUES (?)";
    private static final String TIE_PRODUCT_QUERY = "INSERT INTO cart_products (cart_id, product_id) VALUES (?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT c.id, c.name, p.id as product_id, p.name as product_name, p.price as product_price FROM carts c " +
            "JOIN cart_products cp ON c.id = cp.cart_id " +
            "JOIN products p ON p.id = cp.product_id " +
            "WHERE c.id = ?";
    private static final String FIND_ALL_QUERY = "SELECT id, name FROM carts";

    private final JdbcTemplate jdbcTemplate;

    public CartDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void create(Cart cart) {
        var generatedKeyHolder = new GeneratedKeyHolder();
        var psc = new PreparedStatementCreatorFactory(CREATE_QUERY)
                .newPreparedStatementCreator(Collections.singletonList(cart.getName()));

        jdbcTemplate.update(psc, generatedKeyHolder);

        if (!CollectionUtils.isEmpty(cart.getProducts())) {
            var newCartId = generatedKeyHolder.getKey().intValue();

            List<Object[]> params = new ArrayList<>();
            for (Product product : cart.getProducts()) {
                params.add(new Object[]{newCartId, product.getId()});
            }
            jdbcTemplate.batchUpdate(TIE_PRODUCT_QUERY, params);
        }
    }

    @Override
    @Transactional
    public void delete(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    @Override
    public Optional<Cart> findById(long id) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new BeanPropertyRowMapper<>(Cart.class))
        );
    }

    @Override
    public List<Cart> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, (rs, rowNum) -> {
            var cart = new Cart();
            cart.setId(rs.getLong("id"));
            cart.setName(rs.getString("name"));
            return cart;
        });
    }
}
