package com.github.churakovIA.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(of = {"ref"})
@ToString
@Getter
@Setter
abstract public class AbstractDocument {
    private UUID ref;
    private String number;
    private LocalDateTime dateTime;
    private boolean marked;
    private boolean posted;
}
