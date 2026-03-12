package mj.dbsaas.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AgentDAO {

    private final JdbcTemplate jdbcTemplate;
 

    public boolean existsByToken(String token) {

        String sql = "SELECT COUNT(*) FROM agent WHERE token = ? ";

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                token
        );

        return count != null && count > 0;
    }
}