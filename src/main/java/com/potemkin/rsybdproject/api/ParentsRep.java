package com.potemkin.rsybdproject.api;


import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Parents;

public interface ParentsRep extends CassandraRepository<Parents,Integer>{
    

    @AllowFiltering
    public Parents findByParentId(String parentId);
    
}
