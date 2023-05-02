package cart.infra;

import cart.domain.Product;
import cart.domain.ProductRepository;
import cart.domain.Products;
import cart.infra.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDao extends NamedParameterJdbcDaoSupport implements ProductRepository {

    private static final String TABLE_NAME = "product";
    private static final ProductRowMapper ROW_MAPPER = new ProductRowMapper();

    public ProductDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Products findAll() {
        final String query = String.format("SELECT * FROM %s", TABLE_NAME);
        List<Product> products = getNamedParameterJdbcTemplate()
                .query(query, ROW_MAPPER);

        return new Products(products);
    }

}
