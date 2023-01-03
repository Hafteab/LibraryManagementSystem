package com.example.libray_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name= "publishers")
public class Publisher {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name= "name" , length = 50 , nullable = false , unique = true)
    private String name;

    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();
}

