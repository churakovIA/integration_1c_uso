package com.github.churakovIA.model;

import java.time.LocalDateTime;

abstract public class AbstractInfoRg {
    private LocalDateTime period;

    public LocalDateTime getPeriod() {
        return period;
    }

    public void setPeriod(LocalDateTime period) {
        this.period = period;
    }
}
