package com.nidhisn.bugtracker.dto.dashboard;

public class DashboardCountsDTO {
    private long total;
    private long resolved;
    private long in_progress;
    private long closed;

    public DashboardCountsDTO(long total, long resolved, long in_progress, long closed) {
        this.total = total;
        this.resolved = resolved;
        this.in_progress = in_progress;
        this.closed = closed;
    }

    public long getClosed() {
        return closed;
    }

    public void setClosed(long closed) {
        this.closed = closed;
    }

    public long getIn_progress() {
        return in_progress;
    }

    public void setIn_progress(long in_progress) {
        this.in_progress = in_progress;
    }

    public long getResolved() {
        return resolved;
    }

    public void setResolved(long resolved) {
        this.resolved = resolved;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
