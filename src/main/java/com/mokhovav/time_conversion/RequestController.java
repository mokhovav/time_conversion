package com.mokhovav.time_conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @Autowired
    private TimeConverter tc;

    @RequestMapping(
            value = "/convert",
            method  = RequestMethod.GET,
            consumes="application/json",
            produces="application/json",
            params = { "to", "time" })
    public RequestResponse get(
            @RequestParam(name = "from", required = false, defaultValue = "Europe/Moscow") String from,
            @RequestParam(name = "to") String to,
            @RequestParam(name = "time") long time) {
        return tc.conversionTimeZone(from, to, time);
    }
}
