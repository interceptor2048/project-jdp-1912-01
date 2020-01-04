package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "ORDER_NAME")
    private String orderName;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    //MANY TO ONE DO USERS
}
