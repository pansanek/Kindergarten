package com.potemkin.rsybdproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.potemkin.rsybdproject.api.ParentsRep;
import com.potemkin.rsybdproject.models.Parents;


@RestController
@RequestMapping("/parents")
public class ParentsController {

    @Autowired
    ParentsRep repo;

    @GetMapping("/all-parents")
    public List<Parents> getAll(){
        List<Parents> parents = (List<Parents>) repo.findAll();
        return parents;
    }
    
    @PostMapping("/upload-parents")
    public Parents uploadParents(@RequestBody Parents parents){
        repo.save(parents);
        return parents;

    }

    @GetMapping("/delete-parents")
    public Parents deleteParents(@RequestParam(name="parentId") String parentId){
        Parents parents = repo.findByParentId(parentId);
        repo.delete(parents);
        return parents;
    }
    
}
