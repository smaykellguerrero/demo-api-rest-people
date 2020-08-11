package com.smaykell.demo.payload.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonResponse {

    private Long id;

    private String name;

    private String gender;

    private Date birthDate;

    private Double weight;

    private Double height;

}