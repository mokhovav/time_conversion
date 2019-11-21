package com.mokhovav.time_conversion;

import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Configuration  //The @Configuration annotation indicates that the class is a source of bean definitions
public class TimeConverter {
    public RequestResponse conversionTimeZone(String from, String to, long time){
        RequestResponse rr = new RequestResponse();
        rr.original_timestamp = String.valueOf(time);
        rr.original_timezone = from;
        rr.result_timezone = to;
        rr.result_timestamp = "";
       try {
            ZoneId fromZone = ZoneId.of(from);
            ZoneId toZone = ZoneId.of(to);
            ZonedDateTime fromZDT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(time), fromZone);
            ZonedDateTime toZDT = fromZDT.withZoneSameInstant(toZone);
            rr.result_timestamp = String.valueOf(time + ((long)toZDT.getOffset().getTotalSeconds() - (long)fromZDT.getOffset().getTotalSeconds()) * 1000);
       }
       catch (Exception e){
            rr.error = e.getMessage();
       }
        return rr;
    }
}
