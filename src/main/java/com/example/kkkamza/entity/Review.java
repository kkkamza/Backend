package com.example.kkkamza.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Setter
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name = "description")
    private String description;

    @Column(name = "star")
    private Long star;

    @ManyToOne
    private Market market;


    public Review() {}
}
