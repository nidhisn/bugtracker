package com.nidhisn.bugtracker.controller;

import com.nidhisn.bugtracker.dto.BugRequestDTO;
import com.nidhisn.bugtracker.dto.BugResponseDTO;
import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;
import com.nidhisn.bugtracker.service.BugService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @PostMapping
    public BugResponseDTO createBug(@RequestBody BugRequestDTO dto) {
        return bugService.createBug(dto);
    }

    @GetMapping
    public List<BugResponseDTO> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/{id}")
    public BugResponseDTO getBugById(@PathVariable Long id) {
        return bugService.getBugById(id);
    }

    @PutMapping("/{id}/status")
    public BugResponseDTO updateStatus(@PathVariable Long id,
                            @RequestParam StatusEnum status) {
        return bugService.updateBugStatus(id, status);
    }

    @PutMapping("/{id}/assign")
    public BugResponseDTO assignBug(@PathVariable Long id,
                         @RequestParam String assignedTo) {
        return bugService.assignBug(id, assignedTo);
    }

    @GetMapping("/status")
    public List<BugResponseDTO> getByStatus(@RequestParam StatusEnum status) {
        return bugService.getBugsByStatus(status);
    }

    @GetMapping("/priority")
    public List<BugResponseDTO> getByPriority(@RequestParam PriorityEnum priority) {
        return bugService.getBugsByPriority(priority);
    }




}
