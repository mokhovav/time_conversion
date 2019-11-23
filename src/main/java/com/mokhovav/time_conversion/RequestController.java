package com.mokhovav.time_conversion;

import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    private TimeConverter tc;
    public RequestController(TimeConverter tc) {
        this.tc = tc;
    }

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

    @ExceptionHandler(Exception.class)
    public ErrorResponse  handleException(Exception exception) {
        ErrorResponse er = new ErrorResponse();
        er.error = exception.getMessage();
        return er;
    }
}
