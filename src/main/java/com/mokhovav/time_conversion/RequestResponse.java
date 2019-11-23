package com.mokhovav.time_conversion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@JsonPropertyOrder
@Component
public class RequestResponse {
    private static int count = 0;
    public RequestResponse(){
        count++;
    }

    public String originalTimezone;
    public String originalTimestamp;
    public String resultTimezone;
    public String resultTimestamp;
    public String error;

    @Override
    public String toString(){
        return "Number of objects \"RequestResponse\" = " + count;
    }
}


