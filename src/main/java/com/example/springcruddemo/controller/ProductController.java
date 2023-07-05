package com.example.springcruddemo.controller;

import com.example.springcruddemo.model.Product;
import com.example.springcruddemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products-tittle")
    public String findByTittle(@RequestParam(name = "tittle", required = false) String tittle, Model model) {
//    public String findByTittle(Model model, @Param("tittle") String tittle) {
        List<Product> productList = productService.findByTittle(tittle);
        model.addAttribute("products", productService.findByTittle(tittle));
        model.addAttribute("tittle", productList);
        return "product-list";
    }

    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product-list.html";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product) {
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    @GetMapping("/product-info/{id}")
    public String getProductInfo(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }


}
