package com.example.kkkamza.repository;

import com.example.kkkamza.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByFoodNameContaining(String foodName);
}
