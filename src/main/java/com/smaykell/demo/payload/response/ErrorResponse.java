package com.smaykell.demo.payload.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    private Date timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

}