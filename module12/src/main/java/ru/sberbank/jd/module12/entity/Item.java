package ru.sberbank.jd.module12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String article;

    private String name;

    private Double priceRUB;

    @ManyToOne
    private Order order;
}
