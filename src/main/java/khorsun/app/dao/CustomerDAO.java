package khorsun.app.dao;

import khorsun.app.mappers.CustomerMapper;
import khorsun.app.models.Customers;

import khorsun.app.service.CustomerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

//method show for CustomerValidator
    public Optional<Customers> show(String email){
        return jdbcTemplate.query("select * from restaurant.customers where email=?",
                new Object[]{email},new CustomerMapper()).stream().findAny();
    }


    @Override
    public Customers show(int id) {
        return jdbcTemplate.query("select * from restaurant.customers where id=?", new Object[]{id},
                new CustomerMapper()).stream().findAny().orElse(null);
    }



    @Override
    public void update(int id,Customers updatedCustomers) {
        jdbcTemplate.update("update restaurant.customers set name=?,email=?,phone_number=? where id=?",
                updatedCustomers.getName(),
                updatedCustomers.getEmail(),
                updatedCustomers.getPhoneNumber(),
                id);
    }

    @Override
    public void delete(int id) {
       jdbcTemplate.update("delete from restaurant.customers where id=?",id);
    }
}
