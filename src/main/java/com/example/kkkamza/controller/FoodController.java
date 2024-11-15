package com.example.kkkamza.controller;


import com.example.kkkamza.dto.request.RegisterFoodRequestDto;
import com.example.kkkamza.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/food/register")
    public String registerfood(@RequestBody RegisterFoodRequestDto requestDto){

        return foodService.registerFood(requestDto);
    }
}
