package ru.sberbank.jd.module12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "CLIENT_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime createdDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<Item> items;
}
