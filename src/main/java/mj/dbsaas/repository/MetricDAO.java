package mj.dbsaas.repository;

import mj.dbsaas.dto.MetricPointDTO;
import mj.dbsaas.mapper.MetricRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MetricDAO {

    private final JdbcTemplate jdbcTemplate;

    
    public List<MetricPointDTO> getMetricSeries(long instanceId, String metricName) {

        String sql = "SELECT created_at, CAST(JSON_UNQUOTE(JSON_EXTRACT(payload, CONCAT('$.status.', ?))) AS DECIMAL(20,4)) AS value FROM agent_event WHERE event_type='metric' AND instance_id=? ORDER BY id DESC LIMIT 200 ";

        return jdbcTemplate.query(
                sql,
                new MetricRowMapper(),
                metricName,
                instanceId
        );
    }
}