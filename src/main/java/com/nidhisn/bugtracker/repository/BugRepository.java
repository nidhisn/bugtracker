package com.nidhisn.bugtracker.repository;

import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> findByStatus(StatusEnum status);

    List<Bug> findByPriority(PriorityEnum priority);


}
