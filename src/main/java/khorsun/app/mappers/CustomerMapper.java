package khorsun.app.mappers;

import khorsun.app.models.Customers;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customers> {
    private static final Logger log=Logger.getLogger(CustomerMapper.class);
    @Override
    public Customers mapRow(ResultSet resultSet, int i) throws SQLException {
        log.info("customer row mapper start");

        Customers customers = new Customers();
        customers.setId(resultSet.getInt("id"));
        customers.setName(resultSet.getString("name"));
        customers.setEmail(resultSet.getString("email"));
        customers.setPhoneNumber(resultSet.getString("phone_number"));
        customers.setCreationDate(resultSet.getTimestamp("creation_date"));
        customers.setModificationDate(resultSet.getTimestamp("modification_date"));

        log.info("customer row mapper end");
        return customers;
    }

}
