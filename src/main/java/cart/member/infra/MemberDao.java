package cart.infra;

import cart.domain.Member.MemberRepository;
import cart.domain.Member.Members;
import cart.domain.Member.Member;
import cart.infra.rowmapper.MemberRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberDao extends NamedParameterJdbcDaoSupport implements MemberRepository {

    private static final String TABLE_NAME = "member";
    private static final MemberRowMapper ROW_MAPPER = new MemberRowMapper();


    public MemberDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Members findAll() {
        final String query = String.format("SELECT * FROM %s", TABLE_NAME);
        List<Member> members = getNamedParameterJdbcTemplate().query(query, ROW_MAPPER);

        return new Members(members);
    }

}
