package com.potemkin.rsybdproject.api;


import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Educators;

public interface EducatorsRep extends CassandraRepository<Educators,Integer>{
    

    @AllowFiltering
    public Educators findEducatorsBySecondName(String SecondName);
}
