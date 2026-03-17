package com.nidhisn.bugtracker.repository;

import com.nidhisn.bugtracker.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long> {


}
