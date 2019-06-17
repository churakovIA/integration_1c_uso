package com.github.churakovIA.repository;

import com.github.churakovIA.model.CanCoordinated;
import com.github.churakovIA.model.CoordinationStatus;

import java.util.List;

public interface CoordinationStatusesRepository {
    List<CoordinationStatus> getLastByDocuments(List<? extends CanCoordinated> docs);
}
