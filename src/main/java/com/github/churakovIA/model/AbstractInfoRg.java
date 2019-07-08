package com.github.churakovIA.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
abstract public class AbstractInfoRg {
    private LocalDateTime period;
}
