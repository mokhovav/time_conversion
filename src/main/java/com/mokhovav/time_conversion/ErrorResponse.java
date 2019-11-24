package com.mokhovav.time_conversion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@JsonPropertyOrder
@Component
@Lazy
public class ErrorResponse {
    public String error = "error";
}
