package com.potemkin.rsybdproject.models;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("children")
public class Children {
    @PrimaryKeyColumn(name="second_name",ordinal=0,type=PrimaryKeyType.PARTITIONED)
    private String secondName;

    @PrimaryKeyColumn(name="first_name",ordinal=0,type=PrimaryKeyType.CLUSTERED,ordering = Ordering.ASCENDING)
    private String firstName;

    @PrimaryKeyColumn(name="group_name",ordinal=0,type=PrimaryKeyType.CLUSTERED,ordering = Ordering.ASCENDING)
    private String groupName;

    @Column("age")
    private Integer age;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    

    

}
