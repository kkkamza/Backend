package com.example.kkkamza.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMarketRequestDto {

    private String marketName;
    private String address;
    private String phoneNumber;

}
