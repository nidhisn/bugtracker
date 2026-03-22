package com.nidhisn.bugtracker.service;

import com.nidhisn.bugtracker.dto.dashboard.*;
import com.nidhisn.bugtracker.entity.PriorityEnum;
import com.nidhisn.bugtracker.entity.StatusEnum;
import com.nidhisn.bugtracker.repository.BugRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {

    private final BugRepository bugRepository;

    public DashboardService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    // ✅ 1. COUNTS
    public DashboardCountsDTO getCounts() {
        long total = bugRepository.count();
        long resolved = bugRepository.countByStatus(StatusEnum.RESOLVED);
        long pending = bugRepository.countByStatus(StatusEnum.OPEN);

        return new DashboardCountsDTO(total, resolved, pending, 0);
    }

    // ✅ 2. SEVERITY
    public PriorityDTO getPriority() {
        long high = bugRepository.countByPriority(PriorityEnum.HIGH);
        long medium = bugRepository.countByPriority(PriorityEnum.MEDIUM);
        long low = bugRepository.countByPriority(PriorityEnum.LOW);
        long critical=bugRepository.countByPriority(PriorityEnum.CRITICAL);

        return new PriorityDTO(medium, low, high, critical);
    }

    // ✅ 3. TREND (IMPORTANT PART)
    public List<TrendDTO> getTrend() {

        List<Object[]> createdData = bugRepository.countCreatedBugsByDate();
        List<Object[]> resolvedData = bugRepository.countResolvedBugsByDate();

        // Map<Date, Count>
        Map<String, Long> createdMap = new HashMap<>();
        Map<String, Long> resolvedMap = new HashMap<>();

        for (Object[] obj : createdData) {
            createdMap.put(obj[0].toString(), (Long) obj[1]);
        }

        for (Object[] obj : resolvedData) {
            resolvedMap.put(obj[0].toString(), (Long) obj[1]);
        }

        // Combine all dates
        Set<String> allDates = new TreeSet<>();
        allDates.addAll(createdMap.keySet());
        allDates.addAll(resolvedMap.keySet());

        List<TrendDTO> result = new ArrayList<>();

        for (String date : allDates) {
            long created = createdMap.getOrDefault(date, 0L);
            long resolved = resolvedMap.getOrDefault(date, 0L);

            result.add(new TrendDTO(date, created, resolved));
        }

        return result;
    }
}