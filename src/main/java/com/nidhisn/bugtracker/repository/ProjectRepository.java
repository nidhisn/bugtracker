package com.nidhisn.bugtracker.repository;
import com.nidhisn.bugtracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
