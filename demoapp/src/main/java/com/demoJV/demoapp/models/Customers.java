package com.demoJV.demoapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "fullname")
    public  String name;

    @Column(name = "surname")
    public String surname;

    @Column(name = "phone")
    public int phone;

    @OneToOne(mappedBy = "customer")
    private Users user;
}
