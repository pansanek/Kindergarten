package com.potemkin.rsybdproject.api;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Children;

public interface ChildrenRep extends CassandraRepository<Children,Integer>{
    

    @AllowFiltering
    public Children findChildrenByFirstNameAndAge(String firstName,Integer age);


    @AllowFiltering
    public List<Children> findByAge(Integer age);
}
