package com.github.churakovIA.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class CoordinationStatus extends AbstractInfoRg {
    private UUID document;
    private String status;
}
