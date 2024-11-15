package com.example.kkkamza.service;


import com.example.kkkamza.dto.request.PaymentFoodRequest;
import com.example.kkkamza.dto.request.RegisterFoodRequestDto;
import com.example.kkkamza.entity.Cost;
import com.example.kkkamza.entity.Food;
import com.example.kkkamza.entity.Market;
import com.example.kkkamza.repository.CostRepository;
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
    private final CostRepository costRepository;

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

    /**
     * 음식 선택
     */
    public Food selectFood(Long foodId){

        return foodRepository.findById(foodId).orElseThrow(
                () -> new IllegalArgumentException("해당 음식이 확인되지 않습니다."));
    }

    /**
     * 음식 정보 삭제
     * @param foodId 삭제할 음식 ID
     * @return
     */
    public String deleteFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("해당 음식을 찾을 수 없습니다. ID: " + foodId));

        // 음식 삭제
        foodRepository.delete(food);

        // 삭제된 음식의 이름 반환 (예시: 음식 이름)
        return "삭제된 음식: " + food.getFoodName();
    }

    /**
     * 결제 요청
     */
    public String payment(PaymentFoodRequest request){
        Food food = foodRepository.findById(request.getFoodId()).orElseThrow(
                () -> new IllegalArgumentException("해당 음식이 존재하지 않습니다."));

        if(food.getNumber() < request.getNumber()){
            throw new IllegalArgumentException("해당하는 수량의 결제가 불가능합니다.");
        }

        food.setNumber(food.getNumber() - request.getNumber());
        Cost cost = costRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException());

        cost.setTotalCost(cost.getTotalCost() + (food.getPrice() * request.getNumber()) / 10);

        return "결제가 완료되었습니다!";
    }

    public Integer getPrice(){
        Cost cost = costRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException());

        return cost.getTotalCost();
    }

    public String start() {
        Cost cost = new Cost();

        costRepository.save(cost);

        return "ok";
    }

}
