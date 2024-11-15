package com.example.kkkamza.dto.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFoodRequestDto {
    private String foodName;

    private Integer price;

    private String imageUrl;

    private String description;

    private String expirationdate;

    private Integer number;

    private Long marketId;
}
