package com.github.churakovIA.to;

import java.time.LocalDateTime;

public class AnalyticsAdjustmentTo {
    private boolean marked;
    private boolean posted;
    private String number;
    private LocalDateTime dateTime;
    private String status;
    private LocalDateTime statusDateTime;
    private String comment;

    public AnalyticsAdjustmentTo(boolean marked, boolean posted, String number, LocalDateTime dateTime, String status, LocalDateTime statusDateTime, String comment) {
        this.marked = marked;
        this.posted = posted;
        this.number = number;
        this.dateTime = dateTime;
        this.status = status;
        this.statusDateTime = statusDateTime;
        this.comment = comment;
    }
}
