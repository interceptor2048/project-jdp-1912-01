package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products_groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "group_id")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, List<Product> products) {
        this.groupName = groupName;
        this.products = products;
    }
}
