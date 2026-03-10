package mj.dbsaas.repository;

import mj.dbsaas.model.AgentEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EventRepository {

    private final JdbcTemplate jdbc;

    public void save(AgentEvent ev){

        jdbc.update("insert into agent_event (tenant_id, instance_id,agent_id,ts, seq, event_type, payload) values (?,?,?,?,?,?,?)",
        ev.getTenantId(),
        ev.getInstanceId(),
        ev.getAgentId(),
        ev.getTs(),
        ev.getSeq(),
        ev.getType(),
        ev.getPayload().toString()
        );
    }

}