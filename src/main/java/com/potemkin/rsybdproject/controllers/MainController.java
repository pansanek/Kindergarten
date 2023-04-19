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

import com.potemkin.rsybdproject.api.CassandraRep;
import com.potemkin.rsybdproject.models.Children;


@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    CassandraRep repo;

    @GetMapping("/api")
    public String test(){
        return "hui";
    }
    @GetMapping("/all-children")
    public List<Children> getAll(){
        List<Children> children = (List<Children>) repo.findAll();
        return children;
    }
    
    @PostMapping("/upload-children")
    public Children uploadChildren(@RequestBody Children children){
        repo.save(children);
        return children;

    }

    @GetMapping("/delete-children")
    public Children deleteChild(@RequestParam(name="childName") String childName, @RequestParam(name="age") Integer age){
        Children children = repo.findChildrenByChildNameAndAge(childName, age);
        repo.delete(children);
        return children;
    }
    
    @GetMapping("/get-by-age/{age}")
    public List<Children> getAgedChildren(@PathVariable("age") Integer age){
        return (List<Children>) repo.findByAge(age);
    }
}
