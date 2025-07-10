package com.demoJV.demoapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Catalogs")
public class Cataloges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<Products> product;
}
