package cart.infra.rowmapper;

import cart.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;


public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) {
        return null;
    }

}
