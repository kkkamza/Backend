package com.example.kkkamza.controller;


import com.example.kkkamza.dto.request.RegisterFoodRequestDto;
import com.example.kkkamza.entity.Food;
import com.example.kkkamza.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/food/register")
    public String registerFood(@RequestBody RegisterFoodRequestDto requestDto){

        return foodService.registerFood(requestDto);
    }

    @GetMapping("/food/search")
    public List<Food> searchFood(@RequestParam String requestDto){

        return foodService.searchFood(requestDto);
    }
}
