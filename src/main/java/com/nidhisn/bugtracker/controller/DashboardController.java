package com.nidhisn.bugtracker.controller;

import com.nidhisn.bugtracker.dto.dashboard.*;
import com.nidhisn.bugtracker.service.DashboardService;
import jakarta.annotation.Priority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin // for React
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/counts")
    public DashboardCountsDTO getCounts() {
        return dashboardService.getCounts();
    }

    @GetMapping("/priority")
    public PriorityDTO getSeverity() {
        return dashboardService.getPriority();
    }

    @GetMapping("/trend")
    public List<TrendDTO> getTrend() {
        return dashboardService.getTrend();
    }
}