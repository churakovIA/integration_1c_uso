package com.github.churakovIA.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String root() {
        log.debug("root");
        return "redirect:analyticsAdjustment";
    }

    @GetMapping("/analyticsAdjustment")
    public String analyticsAdjustment() {
        log.debug("analyticsAdjustment");
        return "analytics_adjustment";
    }
}
