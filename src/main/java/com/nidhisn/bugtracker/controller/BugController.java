package com.nidhisn.bugtracker.controller;

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
    public Bug createBug(@RequestBody Bug bug) {
        return bugService.createBug(bug);
    }

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/{id}")
    public Bug getBugById(@PathVariable Long id) {
        return bugService.getBugById(id);
    }

    @PutMapping("/{id}/status")
    public Bug updateStatus(@PathVariable Long id,
                            @RequestParam StatusEnum status) {
        return bugService.updateBugStatus(id, status);
    }

    @PutMapping("/{id}/assign")
    public Bug assignBug(@PathVariable Long id,
                         @RequestParam String assignedTo) {
        return bugService.assignBug(id, assignedTo);
    }

    @GetMapping("/status")
    public List<Bug> getByStatus(@RequestParam StatusEnum status) {
        return bugService.getBugsByStatus(status);
    }

    @GetMapping("/priority")
    public List<Bug> getByPriority(@RequestParam PriorityEnum priority) {
        return bugService.getBugsByPriority(priority);
    }




}
