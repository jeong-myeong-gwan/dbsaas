package mj.dbsaas.service;

import mj.dbsaas.repository.AgentEventDAO;
import mj.dbsaas.dto.AgentEventDTO;
import mj.dbsaas.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentEventService {

    private final AgentEventDAO dao;

    public AgentEventService(AgentEventDAO dao) {
        this.dao = dao;
    }

    public Page<AgentEventDTO> getPagedEvents(int page, int pageSize) {

        int total = dao.getTotalCount();

        int offset = (page - 1) * pageSize;

        List<AgentEventDTO> list =
                dao.getPagedEvents(offset, pageSize);

        return new Page<>(list, total, page, pageSize);
    }
}