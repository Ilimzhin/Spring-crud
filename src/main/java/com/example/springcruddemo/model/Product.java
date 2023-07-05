package com.example.springcruddemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_tittle")
    private String tittle;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_price")
    private int price;
    @Column(name = "product_city")
    private String city;
    @Column(name = "product_author")
    private String author;

}
