package com.potemkin.rsybdproject.api;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Educators;

public interface EducatorsRep extends CassandraRepository<Educators,Integer>{
    

    @AllowFiltering
    public Educators findEducatorsByFirstNameAndAge(String firstName,Integer age);

    @AllowFiltering
    public List<Educators> findByAge(Integer age);
}
