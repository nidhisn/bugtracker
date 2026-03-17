package com.nidhisn.bugtracker.service;

import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;
import com.nidhisn.bugtracker.exception.ResourceNotFoundException;
import com.nidhisn.bugtracker.repository.BugRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugServiceImpl implements BugService{

    private final BugRepository bugRepository;

    public BugServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }


    @Override
    public Bug createBug(Bug bug) {
        if (bug.getStatus() == null) {
            bug.setStatus(StatusEnum.OPEN);
        }

        if (bug.getPriority() == null) {
            bug.setPriority(PriorityEnum.MEDIUM);
        }

        return bugRepository.save(bug);
    }

    @Override
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    @Override
    public Bug getBugById(Long id) {
        return bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));
    }

    @Override
    public Bug updateBugStatus(Long id, StatusEnum status) {
        Bug bug = getBugById(id);
        bug.setStatus(status);
        return bugRepository.save(bug);
    }

    @Override
    public Bug assignBug(Long id, String assignedTo) {
        Bug bug = getBugById(id);

        if (assignedTo == null || assignedTo.isBlank()) {
            throw new IllegalArgumentException("Assigned user cannot be empty");
        }

        bug.setAssignedTo(assignedTo);
        return bugRepository.save(bug);
    }

    @Override
    public List<Bug> getBugsByStatus(StatusEnum status) {
        return bugRepository.findByStatus(status);
    }

    @Override
    public List<Bug> getBugsByPriority(PriorityEnum priority) {
        return bugRepository.findByPriority(priority);
    }
}
