package mj.dbsaas.repository;

import mj.dbsaas.model.AgentEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EventRepository {

    private final JdbcTemplate jdbc;
    private ObjectMapper om = new ObjectMapper();

    public void save(AgentEvent ev){
    	
    	String paylogJson = "";
    	try {
    		paylogJson = om.writeValueAsString(ev.getPayload());
    	}catch(JsonProcessingException e) {
    		log.debug("JSON 변환 오류:" + e.getMessage()); 		
    	}
    	
        jdbc.update("insert ignore into agent_event (tenant_id, instance_id,agent_id,ts, seq, event_type, payload) values (?,?,?,?,?,?,?)",
        ev.getTenantId(),
        ev.getInstanceId(),
        ev.getAgentId(),
        ev.getTs(),
        ev.getSeq(),
        ev.getType(),
        paylogJson
        );
    }

}