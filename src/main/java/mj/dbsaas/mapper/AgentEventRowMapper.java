package mj.dbsaas.mapper;

import mj.dbsaas.dto.AgentEventDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentEventRowMapper implements RowMapper<AgentEventDTO> {

    @Override
    public AgentEventDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        AgentEventDTO e = new AgentEventDTO();

        e.setId(rs.getLong("id"));
        e.setTenantId(rs.getLong("tenant_id"));
        e.setInstanceId(rs.getLong("instance_id"));
        e.setInstanceName(rs.getString("instance_name"));
        e.setAgentId(rs.getString("agent_id"));

        e.setTs(rs.getLong("ts"));
        e.setSeq(rs.getLong("seq"));
        e.setEventType(rs.getString("event_type"));
        e.setPayload(rs.getString("payload"));

        e.setCreatedAt(rs.getTimestamp("created_at"));

        return e;
    }
}