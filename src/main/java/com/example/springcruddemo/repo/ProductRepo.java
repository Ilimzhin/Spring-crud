package com.example.springcruddemo.repo;

import com.example.springcruddemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.tittle LIKE %?1%"
            + " OR p.description LIKE %?1%"
            + " OR p.city LIKE %?1%"
            + " OR p.author LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")
    List<Product> findByTittle(String tittle);
}
