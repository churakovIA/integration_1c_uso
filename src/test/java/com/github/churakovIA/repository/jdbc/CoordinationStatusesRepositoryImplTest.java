package com.github.churakovIA.repository.jdbc;

import com.github.churakovIA.AbstractTest;
import com.github.churakovIA.model.CanCoordinated;
import com.github.churakovIA.model.CoordinationStatus;
import com.github.churakovIA.repository.CoordinationStatusesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.churakovIA.utils.Util1C.convertStringGUID;

class CoordinationStatusesRepositoryImplTest extends AbstractTest {

    @Autowired
    CoordinationStatusesRepository repository;

    @Test
    void getLastByDocuments() {

        List<CanCoordinated> list = Stream.of(
                "f12143bc-6310-11e9-80f4-002590f9e7aa",
                "9b056499-6330-11e9-80f4-002590f9e7aa",
                "e931a3f4-6330-11e9-80f4-002590f9e7aa",
                "191e502f-6331-11e9-80f4-002590f9e7aa",
                "4bccce86-6331-11e9-80f4-002590f9e7aa",
                "f7e75ea7-62b0-11e9-889c-0cc47ad88e39",
                "f7e75ea8-62b0-11e9-889c-0cc47ad88e39",
                "fad23b38-6503-11e9-80f4-002590f9e7aa",
                "b497c518-650b-11e9-80f4-002590f9e7aa",
                "7cd5d72c-650f-11e9-80f4-002590f9e7aa")
                .map(s -> (CanCoordinated) () -> UUID.fromString(convertStringGUID(s)))
                .collect(Collectors.toList());

        List<CoordinationStatus> lastByDocuments = repository.getLastByDocuments(list);
        Assertions.assertNotNull(lastByDocuments);
        Assertions.assertEquals(10, lastByDocuments.size());
    }
}