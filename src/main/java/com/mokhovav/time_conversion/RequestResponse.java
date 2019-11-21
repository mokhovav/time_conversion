package com.mokhovav.time_conversion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
public class RequestResponse {
    public String original_timezone;
    public String original_timestamp;
    public String result_timezone;
    public String result_timestamp;
    public String error;
}


