package com.nidhisn.bugtracker.service;

import com.nidhisn.bugtracker.dto.BugRequestDTO;
import com.nidhisn.bugtracker.dto.BugResponseDTO;
import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;

import java.util.List;

public interface BugService {
    BugResponseDTO createBug(BugRequestDTO dto);

    List<BugResponseDTO> getAllBugs();

    BugResponseDTO getBugById(Long id);

    BugResponseDTO updateBugStatus(Long id, StatusEnum status);

    BugResponseDTO assignBug(Long id, String assignedTo);

    List<BugResponseDTO> getBugsByStatus(StatusEnum status);

    List<BugResponseDTO> getBugsByPriority(PriorityEnum priority);
}
