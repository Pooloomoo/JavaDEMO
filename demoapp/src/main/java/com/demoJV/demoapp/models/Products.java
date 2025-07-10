package com.demoJV.demoapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public int price;

    @ManyToOne
    @JoinColumn(name = "cataloges",referencedColumnName = "id")
    @JsonBackReference
    public Cataloges catalog;

    @ManyToOne
    @JoinColumn(name = "supplies",referencedColumnName = "id")
    @JsonBackReference
    public Supplies supply;

    @OneToOne(mappedBy = "product")
    public Inventories inventory;
}
