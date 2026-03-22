package com.nidhisn.bugtracker.repository;

import com.nidhisn.bugtracker.entity.Bug;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> findByStatus(StatusEnum status);

    List<Bug> findByPriority(PriorityEnum priority);



    // counts
    long countByStatus(StatusEnum status);
    long countByPriority(PriorityEnum priority);

    // trend - created
    @Query("""
SELECT DATE(b.createdAt), COUNT(b)
FROM Bug b
GROUP BY DATE(b.createdAt)
ORDER BY DATE(b.createdAt)
""")
    List<Object[]> countCreatedBugsByDate();

    // trend - resolved (using your new field)
    @Query("""
SELECT DATE(b.resolvedAt), COUNT(b)
FROM Bug b
WHERE b.resolvedAt IS NOT NULL
GROUP BY DATE(b.resolvedAt)
ORDER BY DATE(b.resolvedAt)
""")
    List<Object[]> countResolvedBugsByDate();


}
