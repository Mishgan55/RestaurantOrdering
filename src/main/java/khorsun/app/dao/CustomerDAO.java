package khorsun.app.dao;

import khorsun.app.models.Customers;
import khorsun.app.utill.CRUDRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDAO implements CRUDRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Object show(Object id) {
        return null;
    }

    @Override
    public List<Customers> index() {
        return jdbcTemplate.query("select * from restaurant.customers", new CustomerMapper());
    }

    @Override
    public Object save(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public Object delete(Object id) {
        return null;
    }
}
