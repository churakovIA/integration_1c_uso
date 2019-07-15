package com.github.churakovIA.to;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class AnalyticsAdjustmentTo {
    private boolean marked;
    private boolean posted;
    private String number;
    private LocalDateTime dateTime;
    private String status;
    private LocalDateTime statusDateTime;
    private String comment;
}
