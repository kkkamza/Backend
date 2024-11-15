package com.example.kkkamza.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateMarketRequestDto {

    private String marketName; //상점 이름
    private String address; // 상점 주소
    private String phoneNumber; // 상점 전화번호

}
