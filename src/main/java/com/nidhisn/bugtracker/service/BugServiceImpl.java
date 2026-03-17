package com.nidhisn.bugtracker.service;

import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.Project;
import com.nidhisn.bugtracker.entity.StatusEnum;
import com.nidhisn.bugtracker.exception.ResourceNotFoundException;
import com.nidhisn.bugtracker.repository.BugRepository;
import com.nidhisn.bugtracker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BugServiceImpl implements BugService{

    private final BugRepository bugRepository;
    private final ProjectRepository projectRepository;

    public BugServiceImpl(BugRepository bugRepository,
                          ProjectRepository projectRepository) {
        this.bugRepository = bugRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public Bug createBug(Bug bug) {

        if (bug.getStatus() == null) {
            bug.setStatus(StatusEnum.OPEN);
        }

        if (bug.getPriority() == null) {
            bug.setPriority(PriorityEnum.MEDIUM);
        }

        // 🔥 FIX: fetch project from DB
        if (bug.getProject() != null && bug.getProject().getId() != null) {
            Long projectId = bug.getProject().getId();

            Project project = projectRepository.findById(projectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

            bug.setProject(project);
        } else {
            throw new RuntimeException("Project is required");
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
