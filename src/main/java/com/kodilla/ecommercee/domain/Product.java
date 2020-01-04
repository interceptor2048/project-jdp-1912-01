package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private Long id;
    private String productName;
    private String productType;
    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group group;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}
