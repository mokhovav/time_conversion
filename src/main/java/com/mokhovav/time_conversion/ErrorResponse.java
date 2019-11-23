package com.mokhovav.time_conversion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.context.annotation.Configuration;

@JsonPropertyOrder
@Configuration
public class ErrorResponse {
    public String error = "error";
}
