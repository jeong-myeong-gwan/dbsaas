package mj.dbsaas.mapper;

import mj.dbsaas.dto.InstanceDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstanceRowMapper implements RowMapper<InstanceDTO> {

    @Override
    public InstanceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        InstanceDTO dto = new InstanceDTO();

        dto.setInstanceId(rs.getLong("instance_id"));
        dto.setTenantId(rs.getLong("tenant_id"));
        dto.setInstanceName(rs.getString("instance_name"));

        return dto;
    }
}