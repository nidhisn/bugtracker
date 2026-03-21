package com.nidhisn.bugtracker.service;

import com.nidhisn.bugtracker.dto.BugRequestDTO;
import com.nidhisn.bugtracker.dto.BugResponseDTO;
import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.Project;
import com.nidhisn.bugtracker.entity.StatusEnum;
import com.nidhisn.bugtracker.exception.ResourceNotFoundException;
import com.nidhisn.bugtracker.mapper.BugMapper;
import com.nidhisn.bugtracker.repository.BugRepository;
import com.nidhisn.bugtracker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public BugResponseDTO createBug(BugRequestDTO dto) {

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        Bug bug = BugMapper.toEntity(dto, project);

        if (bug.getStatus() == null) {
            bug.setStatus(StatusEnum.OPEN);
        }

        if (bug.getPriority() == null) {
            bug.setPriority(PriorityEnum.MEDIUM);
        }

        Bug savedBug = bugRepository.save(bug);

        return BugMapper.toDTO(savedBug);
    }


    @Override
    public List<BugResponseDTO> getAllBugs() {
        return bugRepository.findAll()
                .stream()
                .map(BugMapper::toDTO)
                .toList();
    }



    @Override
    public BugResponseDTO getBugById(Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found"));

        return BugMapper.toDTO(bug);
    }



    @Override
    public BugResponseDTO updateBugStatus(Long id, StatusEnum status) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found"));

        bug.setStatus(status);

        return BugMapper.toDTO(bugRepository.save(bug));
    }



    @Override
    public BugResponseDTO assignBug(Long id, String assignedTo) {

        if (assignedTo == null || assignedTo.isBlank()) {
            throw new IllegalArgumentException("Assigned user cannot be empty");
        }

        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found"));

        bug.setAssignedTo(assignedTo);

        return BugMapper.toDTO(bugRepository.save(bug));
    }



    @Override
    public List<BugResponseDTO> getBugsByStatus(StatusEnum status) {
        return bugRepository.findByStatus(status)
                .stream()
                .map(BugMapper::toDTO)
                .toList();
    }

    @Override
    public List<BugResponseDTO> getBugsByPriority(PriorityEnum priority) {
        return bugRepository.findByPriority(priority)
                .stream()
                .map(BugMapper::toDTO)
                .toList();
    }


}
