package com.github.churakovIA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
abstract public class AbstractTest {

    protected final Logger log = LoggerFactory.getLogger(getClass());

}
