package com.example.kkkamza.service;


import com.example.kkkamza.dto.request.RegisterFoodRequestDto;
import com.example.kkkamza.entity.Food;
import com.example.kkkamza.entity.Market;
import com.example.kkkamza.repository.FoodRepository;
import com.example.kkkamza.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final MarketRepository marketRepository;

    /**
     * 음식 정보 등록
     * @param requestDto
     * @return
     */
    public String registerFood(RegisterFoodRequestDto requestDto){
        Food food = new Food(requestDto);

        Market market = marketRepository.findById(requestDto.getMarketId())
                .orElseThrow(() -> new IllegalArgumentException("해당되는 상점이 존재하지 않습니다."));

        food.setMarket(market);
        foodRepository.save(food);

        return "Food register success";
    }

    /**
     * 음식 정보 검색
     * @param requestDto
     * @return
     */
    public List<Food> searchFood(String requestDto){

        return foodRepository.findByFoodNameContaining(requestDto);
    }
}
