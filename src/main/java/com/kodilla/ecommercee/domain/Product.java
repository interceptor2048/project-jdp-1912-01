package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    private Long id;
    private String productName;
    private String productType;
    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group group;
}
