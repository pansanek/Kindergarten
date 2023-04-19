package com.potemkin.rsybdproject.api;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Children;

public interface CassandraRep extends CassandraRepository<Children,Integer>{
    

    @AllowFiltering
    public Children findChildrenByChildNameAndAge(String childName,Integer age);

    @AllowFiltering
    public List<Children> findByAge(Integer age);
}
