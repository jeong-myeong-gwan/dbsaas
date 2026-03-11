package mj.dbsaas.controller;

import mj.dbsaas.dto.AgentEventDTO;
import mj.dbsaas.dto.AgentEventSearchDTO;
import mj.dbsaas.dto.InstanceDTO;
import mj.dbsaas.service.AgentEventService;
import mj.dbsaas.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agent/event")
public class AgentEventController {

    private final AgentEventService agentEventService;

    
    @GetMapping("/list")
    public String list(
    		@RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "instanceId", required = false) Long instanceId,
            @RequestParam(name = "type", required = false) String type,
            Model model
    ) {

        page = Math.max(page, 1);

        int size = 20;
        int pageGroupSize = 10;
        
        AgentEventSearchDTO search = new AgentEventSearchDTO();
        search.setInstanceId(instanceId);

        if (type != null && !type.trim().isEmpty()) {
            search.setType(type.trim());
        }

        Page<AgentEventDTO> eventPage =
                agentEventService.getPagedEvents(page, size, search);

        int currentPage = eventPage.getCurrentPage();
        int totalPages = eventPage.getTotalPages();

        int startPage =
                ((currentPage - 1) / pageGroupSize) * pageGroupSize + 1;

        int endPage =
                Math.min(startPage + pageGroupSize - 1, totalPages);

        int totalCount =
                eventPage.getTotalElements();

        List<InstanceDTO> instances = agentEventService.getAllInstances();
        List<String> eventTypes = agentEventService.getAllEventTypes();

        model.addAttribute("events", eventPage.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalCount", totalCount);

        model.addAttribute("instanceId", instanceId);
        model.addAttribute("type", type);

        model.addAttribute("instances", instances);
        model.addAttribute("eventTypes", eventTypes);

        model.addAttribute("contentPage", "../content/agent/event_list.jsp");

        return "layout/sub_layout";
    }
    
    @GetMapping("/detail")
    public String eventDetail(
            @RequestParam(name = "id") long id,
            Model model
    ) {

        AgentEventDTO event = agentEventService.getEventById(id);
        String prettyPayload = agentEventService.prettyJson(event.getPayload());

        model.addAttribute("event", event);
        model.addAttribute("prettyPayload", prettyPayload);
        model.addAttribute("contentPage", "../content/agent/event_detail.jsp");

        return "layout/sub_layout";
    }
    
}