package com.nidhisn.bugtracker.dto;

import com.nidhisn.bugtracker.entity.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


public class BugResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String module;

    private PriorityEnum priority;
    private StatusEnum status;
    private EnvironmentEnum environment;

    private String assignedTo;
    private String reportedBy;
    private String buildVersion;

    private String stepsToReproduce;
    private String expectedResult;
    private String actualResult;

    private String comments;

    private LocalDateTime createdAt;

    private Long projectId;
    private String projectName;

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EnvironmentEnum getEnvironment() {
        return environment;
    }

    public void setEnvironment(EnvironmentEnum environment) {
        this.environment = environment;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}