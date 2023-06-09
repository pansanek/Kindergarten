package com.potemkin.rsybdproject.api;


import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.potemkin.rsybdproject.models.Nutrition;

public interface NutritionRep extends CassandraRepository<Nutrition,Integer>{
    

    @AllowFiltering
    public Nutrition findByDayOfWeek(String dayOfWeek);
}
