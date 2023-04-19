package com.potemkin.rsybdproject.models;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("children")
public class Children {
    @PrimaryKeyColumn(name="group_name",ordinal=0,type=PrimaryKeyType.PARTITIONED)
    private String groupName;

    @PrimaryKeyColumn(name="age",ordinal=0,type=PrimaryKeyType.CLUSTERED,ordering = Ordering.ASCENDING)
    private Integer age;

    @PrimaryKeyColumn(name="child_name",ordinal=0,type=PrimaryKeyType.CLUSTERED,ordering = Ordering.ASCENDING)
    private String childName;

    @Column("second_name")
    private String secondName;

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

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    

    

}
