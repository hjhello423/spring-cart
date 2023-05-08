package cart.member.infra;

import cart.member.domain.MemberRepository;
import cart.member.domain.Members;
import cart.member.domain.Member;
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
