package com.github.churakovIA.model;

public class AnalyticsAdjustment extends AbstractDocument implements CanCoordinated {
    private String comment;
    private CoordinationStatus status;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CoordinationStatus getStatus() {
        return status;
    }

    public void setStatus(CoordinationStatus status) {
        this.status = status;
    }

    public AnalyticsAdjustment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AnalyticsAdjustment{" +
                "number='" + getNumber() + '\'' +
                ", dateTime=" + getDateTime() +
                ", marked=" + isMarked() +
                ", posted=" + isPosted() +
                ", comment='" + comment + '\'' +
                '}';
    }
}
