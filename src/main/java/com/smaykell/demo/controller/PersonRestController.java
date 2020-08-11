package com.smaykell.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.smaykell.demo.mapper.PersonMapper;
import com.smaykell.demo.payload.request.PersonRequest;
import com.smaykell.demo.payload.response.PersonResponse;
import com.smaykell.demo.service.IPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestControllerAdvice
@RequestMapping("/api/people")
public class PersonRestController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public List<PersonResponse> findAll() {
        List<PersonResponse> personResponseList = new ArrayList<>();
        personService.findAll().forEach(person -> personResponseList.add(PersonMapper.toResponse(person)));
        return personResponseList;
    }

    @GetMapping("/{id}")
    public PersonResponse findOne(@PathVariable("id") Long id) {
        return PersonMapper.toResponse(personService.findById(id));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse create(@Valid @RequestBody PersonRequest personRequest) {
        return PersonMapper.toResponse(personService.create(PersonMapper.toRepository(personRequest)));
    }

    @PutMapping("/{id}")
    public PersonResponse update(@PathVariable("id") Long id, @Valid @RequestBody PersonRequest personRequest) {
        return PersonMapper.toResponse(personService.updateById(id, PersonMapper.toRepository(personRequest)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.deleteById(id);
    }

}