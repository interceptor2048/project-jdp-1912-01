package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    @NotNull
    private String productName;

    @Column(name = "product_type")
    private String productType;

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group group;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_orders_product",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")}
    )
    private List<Order> orders = new ArrayList<>();
}
