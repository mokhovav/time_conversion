package com.mokhovav.time_conversion;


import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ServerExceptionController {
   /* @ExceptionHandler(value = Exception.class)//Exception.class)
    public ErrorResponse  handleException(Exception exception) {
        ErrorResponse er = new ErrorResponse();
        er.error = exception.getMessage();
        return er;
    }/**/
}
