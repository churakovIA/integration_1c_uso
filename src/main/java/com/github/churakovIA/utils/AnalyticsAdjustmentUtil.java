package com.github.churakovIA.utils;

import com.github.churakovIA.model.AnalyticsAdjustment;
import com.github.churakovIA.to.AnalyticsAdjustmentTo;

import java.time.LocalDateTime;

public class AnalyticsAdjustmentUtil {
    public static AnalyticsAdjustmentTo asTo(AnalyticsAdjustment o) {
        String status = "";
        LocalDateTime statusDateTime = LocalDateTime.of(1, 1, 1, 0, 0);
        if (o.getStatus() != null) {
            status = o.getStatus().getStatus();
            statusDateTime = o.getStatus().getPeriod();
        }
        return new AnalyticsAdjustmentTo(o.isMarked(), o.isPosted(), o.getNumber(), o.getDateTime(),
                status, statusDateTime, o.getComment());
    }
}
