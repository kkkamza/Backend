package com.example.kkkamza.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cost")
@Setter
@Getter
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costId;

    @Column(name = "totalCost")
    private Long totalCost;

    public Cost() {
        this.totalCost = 0L;
    }

}
