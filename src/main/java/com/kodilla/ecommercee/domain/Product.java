package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_orders_product",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    private List<Order> orders = new ArrayList<>();
}
