package com.example.kkkamza.service;

import com.example.kkkamza.dto.request.RegisterMarketRequestDto;
import com.example.kkkamza.entity.Market;
import com.example.kkkamza.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;


    /**
     * 상점 등록
     * @param requestDto
     * @return
     */
    public String registerMarket(RegisterMarketRequestDto requestDto){
        Market market = new Market(requestDto);

        marketRepository.save(market);
        return "Market register success";
    }
}
