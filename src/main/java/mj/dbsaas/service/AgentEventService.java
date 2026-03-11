package mj.dbsaas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import mj.dbsaas.repository.AgentEventDAO;
import mj.dbsaas.dto.AgentEventDTO;
import mj.dbsaas.dto.AgentEventSearchDTO;
import mj.dbsaas.dto.InstanceDTO;
import mj.dbsaas.util.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentEventService {

    private final AgentEventDAO dao;
    private ObjectMapper objectMapper = new ObjectMapper();
    
    public Page<AgentEventDTO> getPagedEvents(int page, int pageSize, AgentEventSearchDTO search) {

        int totalCount = dao.getTotalCount(search);
        int offset = (page - 1) * pageSize;

        List<AgentEventDTO> list = dao.getPagedEvents(offset, pageSize, search);

        return new Page<>(list, totalCount, page, pageSize);
    }

    public AgentEventDTO getEventById(long id) {
        return dao.getEventById(id);
    }

    public String prettyJson(String json) {
        try {
            Object obj = objectMapper.readValue(json, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            return json;
        }
    }

    public List<InstanceDTO> getAllInstances() {
        return dao.getAllInstances();
    }

    public List<String> getAllEventTypes() {
        return dao.getAllEventTypes();
    }
    
}