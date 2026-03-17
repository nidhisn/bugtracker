package com.nidhisn.bugtracker.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    public PriorityEnum getPriority() {
        return priority;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    @Column(length = 1000)
    private String description;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    private String module;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriorityEnum priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnvironmentEnum environment;

    private String assignedTo;

    @Column(nullable = false)
    private String reportedBy;

    private String buildVersion;

    @Column(length = 2000)
    private String stepsToReproduce;

    @Column(length = 1000)
    private String expectedResult;

    @Column(length = 1000)
    private String actualResult;

    private String comments;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}