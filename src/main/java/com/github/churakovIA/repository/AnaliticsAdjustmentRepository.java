package com.github.churakovIA.repository;

import com.github.churakovIA.model.AnalyticsAdjustment;

import java.util.List;
import java.util.UUID;

public interface AnaliticsAdjustmentRepository {

    List<AnalyticsAdjustment> getAll(int rowStart, int pageSize);

    List<AnalyticsAdjustment> getAllFiltered(int rowStart, int pageSize, String filter);

    AnalyticsAdjustment get(UUID uuid);

}
