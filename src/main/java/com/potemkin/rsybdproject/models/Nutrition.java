package com.potemkin.rsybdproject.models;


import java.util.List;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("nutrition")
public class Nutrition {
    @PrimaryKeyColumn(name="day_of_week",ordinal=0,type=PrimaryKeyType.PARTITIONED)
    private String dayOfWeek;

    @Column("breakfast")
    private List<String> Breakfast;

    @Column("lunch")
    private List<String> Lunch;

    @Column("snack")
    private List<String> Snack;
    
    @Column("dinner")
    private List<String> Dinner;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<String> getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(List<String> breakfast) {
        Breakfast = breakfast;
    }

    public List<String> getLunch() {
        return Lunch;
    }

    public void setLunch(List<String> lunch) {
        Lunch = lunch;
    }

    public List<String> getSnack() {
        return Snack;
    }

    public void setSnack(List<String> snack) {
        Snack = snack;
    }

    public List<String> getDinner() {
        return Dinner;
    }

    public void setDinner(List<String> dinner) {
        Dinner = dinner;
    }

   

}
