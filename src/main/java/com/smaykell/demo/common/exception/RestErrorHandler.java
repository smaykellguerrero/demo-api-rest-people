package com.smaykell.demo.common.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.smaykell.demo.payload.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(HttpServletRequest request, NotFoundException nfe) {
        return ErrorResponse.builder().timestamp(new Date()).status(HttpStatus.NOT_FOUND.value())
                .message(nfe.getMessage()).error(HttpStatus.NOT_FOUND.getReasonPhrase()).path(request.getRequestURI())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(HttpServletRequest request,
            MethodArgumentNotValidException manve) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : manve.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : manve.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        return ErrorResponse.builder().timestamp(new Date()).status(HttpStatus.BAD_REQUEST.value())
                .message(errors.toString().replace("[", "").replaceAll("]", ""))
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase()).path(request.getRequestURI()).build();
    }
}