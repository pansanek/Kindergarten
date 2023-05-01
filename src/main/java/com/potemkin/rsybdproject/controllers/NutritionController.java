package com.potemkin.rsybdproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.potemkin.rsybdproject.api.NutritionRep;
import com.potemkin.rsybdproject.models.Nutrition;


@RestController
@RequestMapping("/nutrition")
public class NutritionController {

    @Autowired
    NutritionRep repo;

    @GetMapping("/all-nutrition")
    public List<Nutrition> getAll(){
        List<Nutrition> nutrition = (List<Nutrition>) repo.findAll();
        return nutrition;
    }
    
    @PostMapping("/upload-nutrition")
    public Nutrition uploadNutrition(@RequestBody Nutrition nutrition){
        repo.save(nutrition);
        return nutrition;

    }

    @GetMapping("/{dayOfWeek}")
    public Nutrition getNutritionByDayOfWeek(@PathVariable("day_of_week") String dayOfWeek) {
        Nutrition nutrition = repo.findByDayOfWeek(dayOfWeek);
        return nutrition;
    }

    @GetMapping("/delete-nutrition")
    public Nutrition deleteNutrition(@RequestParam(name="day_of_week") String dayOfWeek){
        Nutrition nutrition = repo.findByDayOfWeek(dayOfWeek);
        repo.delete(nutrition);
        return nutrition;
    }

}
