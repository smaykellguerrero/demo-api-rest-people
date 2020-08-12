package com.smaykell.demo.payload.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonResponse {

    private Long id;

    private String name;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private Double weight;

    private Double height;

}