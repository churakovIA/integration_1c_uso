package com.github.churakovIA.web;

import com.github.churakovIA.model.AnalyticsAdjustment;
import com.github.churakovIA.repository.AnaliticsAdjustmentRepository;
import com.github.churakovIA.to.AnalyticsAdjustmentTo;
import com.github.churakovIA.utils.AnalyticsAdjustmentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ajax/analyticsAdjustment")
public class AnalyticsAdjustmentUIController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private AnaliticsAdjustmentRepository repository;

    public AnalyticsAdjustmentUIController(AnaliticsAdjustmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<AnalyticsAdjustmentTo> getAll(@RequestParam int length, @RequestParam int start,
                                       @RequestParam("search[value]") String str) {
        log.debug("getAll start:{}, length:{}", start, length);
        List<AnalyticsAdjustment> docs = "".equals(str) ? repository.getAll(start, length) :
                repository.getAllFiltered(start, length, str);
        return docs.stream()
                .map(AnalyticsAdjustmentUtil::asTo)
                .collect(Collectors.toList());
    }


}
