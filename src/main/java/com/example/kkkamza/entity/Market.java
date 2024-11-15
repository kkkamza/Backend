package com.example.kkkamza.entity;


import com.example.kkkamza.dto.request.RegisterMarketRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "market")
@Setter
@Getter
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketId;

    @Column(name = "marketName", nullable = false)
    private String marketName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "marketStar", nullable = false)
    private Long marketStar;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Food> foodList = new ArrayList<>();

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Review> reviewList = new ArrayList<>();

    public Market() {}

    public Market(RegisterMarketRequestDto requestDto){
        this.marketName = requestDto.getMarketName();
        this.address = requestDto.getAddress();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.marketStar = 0L;
    }
}
