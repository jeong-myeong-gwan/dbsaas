package mj.dbsaas.mapper;

import mj.dbsaas.dto.MetricPointDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MetricRowMapper implements RowMapper<MetricPointDTO> {

    @Override
    public MetricPointDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        MetricPointDTO dto = new MetricPointDTO();

        dto.setTime(rs.getTimestamp("created_at"));
        dto.setValue(rs.getDouble("value"));

        return dto;
    }
}