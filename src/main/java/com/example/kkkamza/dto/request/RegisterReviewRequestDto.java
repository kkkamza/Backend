package com.example.kkkamza.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReviewRequestDto {
    private Long star;
    private String description;
}
