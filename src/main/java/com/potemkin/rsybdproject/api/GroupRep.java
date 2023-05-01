package com.potemkin.rsybdproject.api;


import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Group;

public interface GroupRep extends CassandraRepository<Group,Integer>{
    

    @AllowFiltering
    public Group findByGroupName(String groupName);

    @AllowFiltering
    public List<Group> findByNumberOfChildren(Integer numberOfChildren);
}
