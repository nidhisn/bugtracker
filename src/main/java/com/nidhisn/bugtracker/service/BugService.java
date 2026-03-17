package com.nidhisn.bugtracker.service;

import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;

import java.util.List;

public interface BugService {
    Bug createBug(Bug bug);

    List<Bug> getAllBugs();

    Bug getBugById(Long id);

    Bug updateBugStatus(Long id, StatusEnum status);

    Bug assignBug(Long id, String assignedTo);

    List<Bug> getBugsByStatus(StatusEnum status);

    List<Bug> getBugsByPriority(PriorityEnum priority);
}
