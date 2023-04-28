package com.potemkin.rsybdproject.models;

import java.util.Collection;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("nutrition")
public class Nutrition {
    @PrimaryKeyColumn(name="day_of_week",ordinal=0,type=PrimaryKeyType.PARTITIONED)
    private String dayOfWeek;

    @Column("breakfast")
    private Collection<String> Breakfast;

    @Column("lunch")
    private Collection<String> Lunch;

    @Column("snack")
    private Collection<String> Snack;
    
    @Column("dinner")
    private Collection<String> Dinner;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Collection<String> getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(Collection<String> breakfast) {
        Breakfast = breakfast;
    }

    public Collection<String> getLunch() {
        return Lunch;
    }

    public void setLunch(Collection<String> lunch) {
        Lunch = lunch;
    }

    public Collection<String> getSnack() {
        return Snack;
    }

    public void setSnack(Collection<String> snack) {
        Snack = snack;
    }

    public Collection<String> getDinner() {
        return Dinner;
    }

    public void setDinner(Collection<String> dinner) {
        Dinner = dinner;
    }

   

}
