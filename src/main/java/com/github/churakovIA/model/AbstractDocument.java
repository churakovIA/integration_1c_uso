package com.github.churakovIA.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

abstract public class AbstractDocument {
    private UUID ref;
    private String number;
    private LocalDateTime dateTime;
    private boolean marked;
    private boolean posted;

    public UUID getRef() {
        return ref;
    }

    public void setRef(UUID ref) {
        this.ref = ref;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDocument that = (AbstractDocument) o;
        return Objects.equals(ref, that.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref);
    }
}
