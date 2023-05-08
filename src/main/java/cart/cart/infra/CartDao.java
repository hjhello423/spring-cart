package cart.infra;

import cart.cart.domain.Cart;
import cart.cart.domain.CartRepository;
import cart.cart.domain.Carts;
import cart.infra.rowmapper.CartRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CartDao extends NamedParameterJdbcDaoSupport implements CartRepository {

    private static final String TABLE_NAME = "cart";
    private static final CartRowMapper ROW_MAPPER = new CartRowMapper();


    public CartDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Carts findAll() {
        final String query = String.format("SELECT * FROM %s", TABLE_NAME);
        List<Cart> carts = getNamedParameterJdbcTemplate().query(query, ROW_MAPPER);

        return new Carts(carts);
    }

}
