package com.smaykell.demo.service;

import java.util.List;

import com.smaykell.demo.entity.Person;

public interface IPersonService {

    Person findById(Long id);

    List<Person> findAll();

    Person create(Person person);

    Person updateById(Long id, Person person);

    void deleteById(Long id);
}