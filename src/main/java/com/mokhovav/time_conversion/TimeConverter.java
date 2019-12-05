package com.mokhovav.time_conversion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Configuration
@Scope("singleton")

public class TimeConverter {

    //private RequestResponse rr;
    //public TimeConverter(RequestResponse rr){
    //    this.rr = rr;
    //}

    public RequestResponse conversionTimeZone(String from, String to, long time) {
        RequestResponse rr = new RequestResponse();
        rr.originalTimestamp = String.valueOf(time);
        rr.originalTimezone = from;
        rr.resultTimezone = to;
        rr.resultTimestamp = "";
        ZoneId fromZone = ZoneId.of(from);
        ZoneId toZone = ZoneId.of(to);
        ZonedDateTime fromZDT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(time), fromZone);
        ZonedDateTime toZDT = fromZDT.withZoneSameInstant(toZone);
        rr.resultTimestamp = String.valueOf(time + ((long) toZDT.getOffset().getTotalSeconds() - (long) fromZDT.getOffset().getTotalSeconds()) * 1000);
        return rr;
    }

}
