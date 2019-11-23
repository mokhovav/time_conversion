package com.mokhovav.time_conversion;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component //The @Configuration annotation indicates that the class is a source of bean definitions
public class TimeConverter {
    private static int count = 0;
    /*@Autowired
    public RequestResponse rr;/**/
    private RequestResponse rr;
    public TimeConverter(RequestResponse rr){
        count++;
        this.rr = rr;
    }/**/
   /*public RequestResponse rr;
    public void setRr(RequestResponse rr) {
        this.rr = rr;
    }/**/

    public RequestResponse conversionTimeZone(String from, String to, long time) {
        //RequestResponse rr = new RequestResponse();
        rr.originalTimestamp = String.valueOf(time);
        rr.originalTimezone = from;
        rr.resultTimezone = to;
        rr.resultTimestamp = "";
        System.out.println(rr.toString());
        System.out.println(this.toString());

        ZoneId fromZone = ZoneId.of(from);
        ZoneId toZone = ZoneId.of(to);
        ZonedDateTime fromZDT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(time), fromZone);
        ZonedDateTime toZDT = fromZDT.withZoneSameInstant(toZone);
        rr.resultTimestamp = String.valueOf(time + ((long) toZDT.getOffset().getTotalSeconds() - (long) fromZDT.getOffset().getTotalSeconds()) * 1000);

        int i = 5 / 0;

        return rr;
    }

    @Override
    public String toString(){
        return "Number of objects \"TimeConverter\" = " + count;
    }
}
