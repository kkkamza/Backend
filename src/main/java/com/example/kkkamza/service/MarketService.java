package com.example.kkkamza.service;

import com.example.kkkamza.dto.request.RegisterMarketRequestDto;
import com.example.kkkamza.dto.request.UpdateMarketRequestDto;
import com.example.kkkamza.entity.Market;
import com.example.kkkamza.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 상점 수정
     * @param updateRequestDto
     * @return
     */
    public Market updateMarket(Long marketId, UpdateMarketRequestDto updateRequestDto) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new IllegalArgumentException("Market not found with ID: " + marketId));

        // 새로운 정보로 업데이트
        market.setMarketName(updateRequestDto.getMarketName());
        market.setAddress(updateRequestDto.getAddress());
        market.setPhoneNumber(updateRequestDto.getPhoneNumber());

        // 수정된 정보를 저장 후 반환
        return marketRepository.save(market);
    }

    /**
     * 상점 정보 확인
     * @param marketName 상점 ID
     * @return 조회된 상점 정보
     */
    public Long findMarketInfo(String marketName) {
        Market market = marketRepository.findByMarketName(marketName);
        return market.getMarketId();
    }

    /**
     * 상점 목록 불러오기
     * @return
     */
    public List<Market> getAllMarkets() {
        // DB에서 모든 상점 정보 조회
        return marketRepository.findAll();
    }






}