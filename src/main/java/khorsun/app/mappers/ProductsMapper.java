package khorsun.app.mappers;

import khorsun.app.models.Products;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsMapper implements RowMapper<Products> {
    @Override
    public Products mapRow(ResultSet resultSet, int i) throws SQLException {
        Products products = new Products();
        products.setId(resultSet.getInt("id"));
        products.setMenuName(resultSet.getString("menu_name"));
        products.setDescription(resultSet.getString("description"));
        products.setPrice(resultSet.getDouble("price"));
        return products;
    }
}
