package mj.dbsaas.service;

import mj.dbsaas.model.AgentEvent;
import mj.dbsaas.parser.NdjsonParser;
import mj.dbsaas.repository.EventRepository;
import mj.dbsaas.util.GzipUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventIngestService {

    private final EventRepository repo;
    private final NdjsonParser parser = new NdjsonParser();

    public EventIngestService(EventRepository repo) {
        this.repo = repo;
    }

    public void ingest(byte[] gzBody) throws Exception {

        byte[] raw = GzipUtil.decompress(gzBody);

        List<AgentEvent> events = parser.parse(raw);

        for(AgentEvent ev : events){
            repo.save(ev);
        }
    }

}