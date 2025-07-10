package com.demoJV.demoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Inventories")
public class Inventories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "amount")
    public int amount;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Products product;
}
