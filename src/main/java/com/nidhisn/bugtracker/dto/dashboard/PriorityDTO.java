package com.nidhisn.bugtracker.dto.dashboard;

public class PriorityDTO {
    private long high;
    private long medium;
    private long low;
    private long critical;

    public PriorityDTO(long medium, long low, long high, long critical) {
        this.medium = medium;
        this.low = low;
        this.high = high;
        this.critical = critical;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getHigh() {
        return high;
    }

    public void setHigh(long high) {
        this.high = high;
    }

    public long getLow() {
        return low;
    }

    public void setLow(long low) {
        this.low = low;
    }

    public long getMedium() {
        return medium;
    }

    public void setMedium(long medium) {
        this.medium = medium;
    }
}
