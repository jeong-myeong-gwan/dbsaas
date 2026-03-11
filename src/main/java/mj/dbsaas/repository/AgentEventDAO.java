package mj.dbsaas.repository;

import mj.dbsaas.dto.AgentEventDTO;
import mj.dbsaas.dto.AgentEventSearchDTO;
import mj.dbsaas.dto.InstanceDTO;
import mj.dbsaas.mapper.AgentEventRowMapper;
import mj.dbsaas.mapper.InstanceRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AgentEventDAO {

    private final JdbcTemplate jdbcTemplate;

    
    public int getTotalCount(AgentEventSearchDTO search) {

        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM agent_event e JOIN instance i ON e.instance_id = i.instance_id WHERE 1=1 ");

        List<Object> params = new ArrayList<>();

        if (search.getInstanceId() != null) {
            sql.append(" AND e.instance_id = ? ");
            params.add(search.getInstanceId());
        }

        if (search.getType() != null && !search.getType().isEmpty()) {
            sql.append(" AND e.event_type = ? ");
            params.add(search.getType());
        }

        return jdbcTemplate.queryForObject(sql.toString(), params.toArray(), Integer.class);
    }

    public List<AgentEventDTO> getPagedEvents(int offset, int pageSize, AgentEventSearchDTO search) {

        StringBuilder sql = new StringBuilder("SELECT e.id, e.tenant_id, e.instance_id, i.instance_name, e.agent_id, e.ts, e.seq, e.event_type, e.payload, e.created_at FROM agent_event e JOIN instance i ON e.instance_id = i.instance_id WHERE 1=1 ");

        List<Object> params = new ArrayList<>();

        if (search.getInstanceId() != null) {
            sql.append(" AND e.instance_id = ? ");
            params.add(search.getInstanceId());
        }

        if (search.getType() != null && !search.getType().isEmpty()) {
            sql.append(" AND e.event_type = ? ");
            params.add(search.getType());
        }

        sql.append(" ORDER BY e.id DESC LIMIT ?, ? ");
        params.add(offset);
        params.add(pageSize);

        return jdbcTemplate.query(
                sql.toString(),
                params.toArray(),
                new AgentEventRowMapper()
        );
    }

    public AgentEventDTO getEventById(long id) {

        String sql = "SELECT e.id, e.tenant_id, e.instance_id, i.instance_name, e.agent_id, e.ts, e.seq, e.event_type, e.payload, e.created_at FROM agent_event e JOIN instance i  ON e.instance_id = i.instance_id WHERE e.id = ? ";

        return jdbcTemplate.queryForObject(
                sql,
                new AgentEventRowMapper(),
                id
        );
    }

    public List<InstanceDTO> getAllInstances() {

        String sql = "SELECT instance_id, tenant_id, instance_name FROM instance ORDER BY instance_id ASC ";

        return jdbcTemplate.query(sql, new InstanceRowMapper());
    }

    public List<String> getAllEventTypes() {

        String sql = "SELECT DISTINCT event_type FROM agent_event ORDER BY event_type ASC ";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getString("event_type")
        );
    }
}