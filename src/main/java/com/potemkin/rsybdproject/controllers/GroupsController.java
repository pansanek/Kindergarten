package com.potemkin.rsybdproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.potemkin.rsybdproject.api.GroupRep;
import com.potemkin.rsybdproject.models.Group;


@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    GroupRep repo;

    @GetMapping("/all-groups")
    public List<Group> getAll(){
        List<Group> group = (List<Group>) repo.findAll();
        return group;
    }
    
    @PostMapping("/upload-groups")
    public Group uploadChildren(@RequestBody Group group){
        repo.save(group);
        return group;

    }

    @GetMapping("/delete-groups")
    public Group deleteGroup(@RequestParam(name="groupName") String groupName){
        Group group = repo.findByGroupName(groupName);
        repo.delete(group);
        return group;
    }
}
