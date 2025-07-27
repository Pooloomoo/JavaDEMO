package com.demoJV.demoapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Size(min = 2)
    @Column(name = "email")
    public String email;

    @Size(min = 5)
    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customers customer;
}
