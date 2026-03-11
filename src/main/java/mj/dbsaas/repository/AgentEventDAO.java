package mj.dbsaas.repository;

import mj.dbsaas.dto.AgentEventDTO;
import mj.dbsaas.mapper.AgentEventRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AgentEventDAO {

    private final JdbcTemplate jdbcTemplate;

    
    public int getTotalCount() {

        String sql = "SELECT COUNT(*) FROM agent_event";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<AgentEventDTO> getPagedEvents(int offset, int size) {

        String sql = "SELECT e.id, e.tenant_id, e.instance_id, i.instance_name, e.agent_id, e.ts, e.seq, e.event_type, e.payload, e.created_at FROM agent_event e JOIN instance i  ON e.instance_id = i.instance_id ORDER BY e.id DESC LIMIT ?, ?";

        return jdbcTemplate.query(
                sql,
                new AgentEventRowMapper(),
                offset,
                size
        );
    }
}