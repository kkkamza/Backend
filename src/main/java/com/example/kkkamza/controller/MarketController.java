package com.example.kkkamza.controller;

import com.example.kkkamza.dto.request.RegisterMarketRequestDto;
import com.example.kkkamza.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @PostMapping("/store")
    public String registerMarket(@RequestBody RegisterMarketRequestDto requestDto){
        return marketService.registerMarket(requestDto);
    }

}
