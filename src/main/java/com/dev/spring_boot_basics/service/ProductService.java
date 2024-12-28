package com.dev.spring_boot_basics.service;

import com.dev.spring_boot_basics.model.Product;
import com.dev.spring_boot_basics.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepo repo;

    @Autowired
    public void setRepo(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    public void addProduct(Product newProduct) {
        repo.save(newProduct);
    }

    public void updateProduct(Product newProduct) {
        repo.save(newProduct);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product("Iphone", 5000),
//            new Product("Canon Camera", 1700),
//            new Product("Macbook", 15000)
//    ));

//    public Product getProductById(int prodId) {
//        return products.stream()
//                .filter(item -> item.getProdId() == prodId)
//                .findFirst()
//                .orElse(null);
//    }

//    public void updateProduct(Product newProduct) {
//        int idx = getProductIdx(newProduct.getProdId());
//
//        if (idx != -1) {
//            products.set(idx, newProduct);
//        }
//    }

//    public void deleteProduct(int prodId) {
//        int idx = getProductIdx(prodId);
//
//        if (idx != -1) {
//            products.remove(idx);
//        }
//    }

//    private int getProductIdx(int prodId) {
//        int idx = -1;
//
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProdId() == prodId) {
//                idx = i;
//            }
//        }
//        return idx;
//    }

