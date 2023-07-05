package com.example.springcruddemo.service;


import com.example.springcruddemo.model.Product;
import com.example.springcruddemo.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

//    @Query("SELECT p FROM Product p WHERE CONCAT(p.tittle, p.description, p.city, p.author, p.price) LIKE %?1%")
    public List<Product> findByTittle(String tittle) {
        if (tittle != null) {
            return productRepo.findByTittle(tittle);
        }
        return productRepo.findAll();
//        if (tittle != null) productRepo.findByTittle(tittle);
//        return productRepo.findAll();
    }

//    public Product findByTittle(String tittle) {
//        return productRepo.findByTittle(tittle);
//    }

    public Product findById(Long id) {
        return productRepo.getOne(id);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

}
