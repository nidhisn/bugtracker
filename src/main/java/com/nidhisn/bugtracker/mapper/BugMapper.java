package com.nidhisn.bugtracker.mapper;

import com.nidhisn.bugtracker.dto.*;
import com.nidhisn.bugtracker.entity.*;

public class BugMapper {

    public static BugResponseDTO toDTO(Bug bug) {
        BugResponseDTO dto = new BugResponseDTO();

        dto.setId(bug.getId());
        dto.setTitle(bug.getTitle());
        dto.setDescription(bug.getDescription());
        dto.setModule(bug.getModule());
        dto.setPriority(bug.getPriority());
        dto.setStatus(bug.getStatus());
        dto.setEnvironment(bug.getEnvironment());
        dto.setAssignedTo(bug.getAssignedTo());
        dto.setReportedBy(bug.getReportedBy());
        dto.setBuildVersion(bug.getBuildVersion());
        dto.setStepsToReproduce(bug.getStepsToReproduce());
        dto.setExpectedResult(bug.getExpectedResult());
        dto.setActualResult(bug.getActualResult());
        dto.setComments(bug.getComments());
        dto.setCreatedAt(bug.getCreatedAt());

        if (bug.getProject() != null) {
            dto.setProjectId(bug.getProject().getId());
            dto.setProjectName(bug.getProject().getName());
        }

        return dto;
    }

    public static Bug toEntity(BugRequestDTO dto, Project project) {
        Bug bug = new Bug();

        bug.setTitle(dto.getTitle());
        bug.setDescription(dto.getDescription());
        bug.setModule(dto.getModule());
        bug.setPriority(dto.getPriority());
        bug.setStatus(dto.getStatus());
        bug.setEnvironment(dto.getEnvironment());
        bug.setAssignedTo(dto.getAssignedTo());
        bug.setReportedBy(dto.getReportedBy());
        bug.setBuildVersion(dto.getBuildVersion());
        bug.setStepsToReproduce(dto.getStepsToReproduce());
        bug.setExpectedResult(dto.getExpectedResult());
        bug.setActualResult(dto.getActualResult());
        bug.setComments(dto.getComments());
        bug.setProject(project);

        return bug;
    }
}