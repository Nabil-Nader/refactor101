package com.refactor.code.smells.duplicate.exception.refactor;


import com.refactor.code.smells.duplicate.dto.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public Response handleAnotherRuntimeException(RuntimeException ex, HttpServletRequest request) {
        String errorMessage = ex.getMessage();
        log.error("error with a message "+ex.getMessage());
            Response response = new Response(ex.getMessage(), BAD_REQUEST.value(),false);
            response.setDebugMessage(ex.getClass().getName());
            response.setData(request.getRequestURI());
        return response ;
    }


}