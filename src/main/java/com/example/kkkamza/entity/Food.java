package com.example.kkkamza.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food")
@Setter
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column(name = "foodName", nullable = false)
    private String foodName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "expirationdate")
    private String expirationdate;

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    private Market market;

    public Food() {}
}
