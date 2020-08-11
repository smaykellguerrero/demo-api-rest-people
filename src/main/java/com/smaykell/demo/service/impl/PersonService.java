package com.smaykell.demo.service.impl;

import java.util.List;

import com.smaykell.demo.common.exception.NotFoundException;
import com.smaykell.demo.entity.Person;
import com.smaykell.demo.repository.PersonRepository;
import com.smaykell.demo.service.IPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    @Override
    public Person updateById(Long id, Person person) {
        Person _person = findById(id);
        _person.setName(person.getName());
        _person.setGender(person.getGender());
        _person.setBirthDate(person.getBirthDate());
        _person.setWeight(person.getWeight());
        _person.setHeight(person.getHeight());
        return _person;
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}