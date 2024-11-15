package com.example.kkkamza.controller;

import com.example.kkkamza.dto.request.RegisterMarketRequestDto;
import com.example.kkkamza.dto.request.UpdateMarketRequestDto;
import com.example.kkkamza.entity.Market;
import com.example.kkkamza.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor

public class MarketController {

    private final MarketService marketService;


    // 상점 등록
    @PostMapping
    public String registerMarket(@RequestBody RegisterMarketRequestDto requestDto){
        return marketService.registerMarket(requestDto);
    }
    
    // 상점 정보 수정
    @PutMapping("/edit/{marketId}")
    public ResponseEntity<Market> updateMarket(
            @PathVariable Long marketId,
            @RequestBody UpdateMarketRequestDto updateRequestDto) {
        Market updatedMarket = marketService.updateMarket(marketId, updateRequestDto);
        return new ResponseEntity<>(updatedMarket, HttpStatus.OK);
    }

    // 상점 정보 확인
    @GetMapping("/{marketId}")
    public ResponseEntity<Market> getMarketInfo(@PathVariable Long marketId) {
        Market market = marketService.findMarketInfo(marketId);
        return ResponseEntity.ok(market);
    }


}
