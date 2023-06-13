package com.refactor.code.dry.principle.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String customerName;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDate date;

}
