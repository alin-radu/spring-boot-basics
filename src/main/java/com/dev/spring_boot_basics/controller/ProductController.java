package com.dev.spring_boot_basics.controller;

import com.dev.spring_boot_basics.model.Product;
import com.dev.spring_boot_basics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    //    @RequestMapping("/products")
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    //    @RequestMapping("/products/{prodId}")
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        Product product = service.getProductById(prodId);
        if (product == null) {
            System.out.println("Product not found with ID: " + prodId);
        }
        return product;
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product newProduct) {
        service.addProduct(newProduct);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product newProduct) {
        service.updateProduct(newProduct);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
    }
}
