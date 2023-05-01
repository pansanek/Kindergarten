package com.potemkin.rsybdproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.potemkin.rsybdproject.api.EducatorsRep;
import com.potemkin.rsybdproject.models.Educators;


@RestController
@RequestMapping("/educators")
public class EducatorsController {

    @Autowired
    EducatorsRep repo;

    @GetMapping("/all-educators")
    public List<Educators> getAll(){
        List<Educators> educators = (List<Educators>) repo.findAll();
        return educators;
    }
    
    @PostMapping("/upload-educators")
    public Educators uploadEducators(@RequestBody Educators educators){
        repo.save(educators);
        return educators;

    }

    @GetMapping("/delete-educators")
    public Educators deleteEducator(@RequestParam(name="secondName") String secondName){
        Educators educators = repo.findEducatorsBySecondName(secondName);
        repo.delete(educators);
        return educators;
    }
    
    @GetMapping("/get-by-age/{age}")
    public List<Educators> getAgeEducators(@PathVariable("age") Integer age){
        return (List<Educators>) repo.findByAge(age);
    }
    
}
