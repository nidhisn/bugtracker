package com.nidhisn.bugtracker.dto.dashboard;

public class TrendDTO {
    private String day;
    private long created;
    private long resolved;

    public TrendDTO(String day, long created, long resolved) {
        this.day = day;
        this.created = created;
        this.resolved = resolved;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getResolved() {
        return resolved;
    }

    public void setResolved(long resolved) {
        this.resolved = resolved;
    }
}
