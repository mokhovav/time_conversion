package com.mokhovav.time_conversion;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Lazy
public class TestRequest {

    public String URL_TIMEZONE = "http://localhost:8080/convert";
    public String original_timezone = "Europe/Moscow";
    public long original_timestamp = new Date().getTime();
    public String result_timezone = "Australia/Sydney";

}