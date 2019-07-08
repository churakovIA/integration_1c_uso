package com.github.churakovIA.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AnalyticsAdjustment extends AbstractDocument implements CanCoordinated {
    private String comment;
    private CoordinationStatus status;

    public AnalyticsAdjustment(String comment) {
        this.comment = comment;
    }
}
