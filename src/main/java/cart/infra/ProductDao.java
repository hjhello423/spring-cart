package cart.infra;

import cart.domain.Product;
import cart.domain.ProductRepository;
import cart.domain.Products;
import cart.infra.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDao extends NamedParameterJdbcDaoSupport implements ProductRepository {

    private static final String TABLE_NAME = "product";
    private static final String ID = "id";
    private static final String[] COLUMNS = {"name", "image", "price"};
    private static final ProductRowMapper ROW_MAPPER = new ProductRowMapper();
    private final SimpleJdbcInsert simpleJdbcInsert;

    public ProductDao(DataSource dataSource) {
        setDataSource(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(ID)
                .usingColumns(COLUMNS);
    }

    @Override
    public Products findAll() {
        final String query = String.format("SELECT * FROM %s", TABLE_NAME);
        List<Product> products = getNamedParameterJdbcTemplate()
                .query(query, ROW_MAPPER);

        return new Products(products);
    }

    @Override
    public void save(Product product) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(product);
        Number key = simpleJdbcInsert.executeAndReturnKey(parameterSource);
        product.updateId(key.longValue());
    }

}
