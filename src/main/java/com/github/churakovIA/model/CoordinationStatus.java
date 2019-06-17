package com.github.churakovIA.model;

import java.util.UUID;

public class CoordinationStatus extends AbstractInfoRg {

    private UUID document;
    private String status;

    public UUID getDocument() {
        return document;
    }

    public void setDocument(UUID document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
