package com.github.churakovIA.repository.jdbc;

import com.github.churakovIA.AbstractTest;
import com.github.churakovIA.model.AnalyticsAdjustment;
import com.github.churakovIA.repository.AnaliticsAdjustmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static com.github.churakovIA.utils.Util1C.convertStringGUID;

class AnaliticsAdjustmentRepositoryImplTest extends AbstractTest {

    @Autowired
    AnaliticsAdjustmentRepository repository;

    @Test
    void getAll() {
        List<AnalyticsAdjustment> list = repository.getAll(2, 5);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(5, list.size());
        list.forEach(doc -> log.debug(doc.toString()));
    }

    @Test
    void get() {
        final String GUID1C = "191e502f-6331-11e9-80f4-002590f9e7aa";
        UUID ref = UUID.fromString(convertStringGUID(GUID1C));
        AnalyticsAdjustment doc = repository.get(ref);
        Assertions.assertNotNull(doc);
    }

}