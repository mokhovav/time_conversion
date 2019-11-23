package com.mokhovav.time_conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    public static Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/")
    public void index() {
        //logger.trace("A TRACE Message");
        //logger.debug("A DEBUG Message");
        logger.info("Request received");
        //logger.warn("A WARN Message");
        //logger.error("An ERROR Message");
        //return "Check out the Logs to see the output...";
    }
}
