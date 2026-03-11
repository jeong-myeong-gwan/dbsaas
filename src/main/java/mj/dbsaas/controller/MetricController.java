package mj.dbsaas.controller;

import mj.dbsaas.dto.MetricPointDTO;
import mj.dbsaas.dto.InstanceDTO;
import mj.dbsaas.service.AgentEventService;
import mj.dbsaas.service.MetricService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agent/metric")
public class MetricController {

    private final MetricService metricService;
    private final AgentEventService agentEventService;

    
    @GetMapping("/chart")
    public String chart(
            @RequestParam(name = "instanceId", required = false, defaultValue = "1") long instanceId,
            @RequestParam(name = "metric", required = false, defaultValue = "Threads_running") String metric,
            Model model
    ) {

        List<MetricPointDTO> series =
                metricService.getMetricSeries(instanceId, metric);

        List<InstanceDTO> instances =
                agentEventService.getAllInstances();

        model.addAttribute("series", series);
        model.addAttribute("instances", instances);
        model.addAttribute("instanceId", instanceId);
        model.addAttribute("metric", metric);

        model.addAttribute("contentPage", "../content/agent/metric_chart.jsp");

        return "layout/sub_layout";
    }
}