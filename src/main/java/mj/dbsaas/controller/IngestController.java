package mj.dbsaas.controller;

import mj.dbsaas.service.EventIngestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class IngestController {

    private final EventIngestService service;

    public IngestController(EventIngestService service) {
        this.service = service;
    }

    @PostMapping
    public String ingest(@RequestBody byte[] body) throws Exception {

        service.ingest(body);

        return "OK";
    }
}