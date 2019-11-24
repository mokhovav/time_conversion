package com.mokhovav.time_conversion;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    private TimeConverter tc;
    private ErrorResponse er;

    public RequestController(TimeConverter tc, ErrorResponse er){
        this.tc = tc;
        this.er = er;
    }

    @RequestMapping(
            value = "/convert",
            method  = RequestMethod.GET,
            consumes="application/json",
            produces="application/json",
            params = { "to", "time" })
    private RequestResponse get(
            @RequestParam(name = "from", required = false, defaultValue = "Europe/Moscow") String from,
            @RequestParam(name = "to") String to,
            @RequestParam(name = "time") long time) {
        return tc.conversionTimeZone(from, to, time);
    }

    @ExceptionHandler(Exception.class)
    private ErrorResponse  handleException(Exception exception) {
        er.error = exception.getMessage();
        return er;
    }
}
