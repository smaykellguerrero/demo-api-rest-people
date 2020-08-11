package com.smaykell.demo.mapper;

import com.smaykell.demo.entity.Person;
import com.smaykell.demo.entity.enumeration.EGender;
import com.smaykell.demo.payload.request.PersonRequest;
import com.smaykell.demo.payload.response.PersonResponse;

public class PersonMapper {

    public static Person toRepository(PersonRequest personRequest) {
        return Person.builder().name(personRequest.getName())
                .gender(EGender.valueOfCode(personRequest.getGender()).orElse(EGender.ERROR))
                .birthDate(personRequest.getBirthDate()).weight(personRequest.getWeight())
                .height(personRequest.getHeight()).build();
    }

    public static PersonResponse toResponse(Person person) {
        return PersonResponse.builder().id(person.getId()).name(person.getName()).gender(person.getGender().getCode())
                .birthDate(person.getBirthDate()).weight(person.getWeight()).height(person.getHeight()).build();
    }

}