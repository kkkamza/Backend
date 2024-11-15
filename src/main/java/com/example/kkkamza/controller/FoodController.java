package com.example.kkkamza.controller;


import com.example.kkkamza.dto.request.PaymentFoodRequest;
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

    @GetMapping("/food/{foodId}")
    public Food selectFood(@PathVariable Long foodId){

        return foodService.selectFood(foodId);
    }

    @DeleteMapping("/food/{foodId}")
    public String deleteFood(@PathVariable Long foodId) {
        return foodService.deleteFood(foodId);
    }

    @PostMapping("/food/payment")
    public String payment(@RequestBody PaymentFoodRequest request){
        return foodService.payment(request);
    }

    @PostMapping("/abc")
    public String start(){
        return foodService.start();
    }
}
