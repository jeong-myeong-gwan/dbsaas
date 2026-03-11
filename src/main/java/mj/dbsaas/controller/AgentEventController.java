package mj.dbsaas.controller;

import mj.dbsaas.dto.AgentEventDTO;
import mj.dbsaas.service.AgentEventService;
import mj.dbsaas.util.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agent/event")
public class AgentEventController {

    private final AgentEventService service;

    
    @GetMapping("/list")
    public String list(
            @RequestParam(defaultValue = "1") int page,
            Model model
    ) {

        page = Math.max(page, 1);

        int size = 20;
        int pageGroupSize = 10;

        Page<AgentEventDTO> eventPage =
                service.getPagedEvents(page, size);

        int currentPage = eventPage.getCurrentPage();
        int totalPages = eventPage.getTotalPages();

        int startPage =
                ((currentPage - 1) / pageGroupSize) * pageGroupSize + 1;

        int endPage =
                Math.min(startPage + pageGroupSize - 1, totalPages);

        int totalCount =
                eventPage.getTotalElements();

        model.addAttribute("events", eventPage.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalCount", totalCount);

        model.addAttribute("contentPage", "../content/agent/event_list.jsp");

        return "layout/sub_layout";
    }
}