package khorsun.app.dao;

import khorsun.app.models.Customers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customers> {
    @Override
    public Customers mapRow(ResultSet resultSet, int i) throws SQLException {
        Customers customers = new Customers();
        customers.setId(resultSet.getInt("id"));
        customers.setName(resultSet.getString("name"));
        customers.setEmail(resultSet.getString("email"));
        customers.setPhoneNumber(resultSet.getString("phone_number"));
        customers.setCreationDate(resultSet.getTimestamp("creation_date"));
        customers.setModificationDate(resultSet.getTimestamp("modification_date"));
        return customers;
    }

}
