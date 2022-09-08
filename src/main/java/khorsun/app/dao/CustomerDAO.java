package khorsun.app.dao;

import khorsun.app.models.Customers;

import khorsun.app.service.CustomerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class CustomerDAO implements CustomerService{

    private final JdbcTemplate jdbcTemplate;

    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Customers> index() {
        return jdbcTemplate.query("select * from restaurant.customers", new CustomerMapper());
    }

    @Override
    public void save(Customers customers) {
        jdbcTemplate.update("insert into restaurant.customers(name, email, phone_number) values (?,?,?)",
                customers.getName(),customers.getEmail(),customers.getPhoneNumber());
    }


    @Override
    public Customers show(int id) {
        return jdbcTemplate.query("select * from restaurant.customers where id=?", new Object[]{id},
                new CustomerMapper()).stream().findAny().orElse(null);
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
