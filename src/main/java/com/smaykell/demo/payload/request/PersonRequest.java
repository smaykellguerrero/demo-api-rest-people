package com.smaykell.demo.payload.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PersonRequest {

    @NotBlank
    @Size(min = 3, max = 35)
    private String name;

    @NotBlank
    @Size(max = 1)
    private String gender;

    @NotNull
    @Past
    private Date birthDate;

    @NotNull
    @Positive
    private Double weight;

    @NotNull
    @Positive
    private Double height;

}