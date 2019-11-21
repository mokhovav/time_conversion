package com.mokhovav.time_conversion;

import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration  //The @Configuration annotation indicates that the class is a source of bean definitions
public class TestRequest {
    public String URL_TIMEZONE = "http://localhost:8080/convert";
    public String original_timezone = "Europe/Moscow";
    public long original_timestamp = new Date().getTime();
    public String result_timezone = "Australia/Sydney";

}