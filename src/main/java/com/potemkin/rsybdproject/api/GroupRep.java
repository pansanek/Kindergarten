package com.potemkin.rsybdproject.api;


import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Group;

public interface GroupRep extends CassandraRepository<Group,Integer>{
    

    @AllowFiltering
    public Group findByGroupName(String groupName);
}
