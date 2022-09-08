package khorsun.app.dao;

import khorsun.app.mappers.CustomerMapper;
import khorsun.app.mappers.ProductsMapper;
import khorsun.app.models.Products;
import khorsun.app.service.ProductsService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductsDao implements ProductsService {

    private final JdbcTemplate jdbcTemplate;

    public ProductsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Object show(int id) {
        return jdbcTemplate.query("select from restaurant.products where id=?", new Object[]{id},
                new CustomerMapper()).stream().findAny().orElse(null);
    }

    @Override
    public List<Products> index() {
        return jdbcTemplate.query("select * from restaurant.products", new ProductsMapper());
    }

    @Override
    public void save(Products products) {
        jdbcTemplate.update("insert into restaurant.products(menu_name, description, price)" +
                " values (?,?,?)", products.getMenuName(),products.getDescription(),products.getPrice());

    }

    @Override
    public void update(int id, Products updatedProducts) {
        jdbcTemplate.update("update restaurant.products set menu_name=?," +
                "description=?,price=? where id=?",updatedProducts.getMenuName(),
                updatedProducts.getDescription(),updatedProducts.getPrice(),id);

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from restaurant.products where id=?",id);

    }
}
