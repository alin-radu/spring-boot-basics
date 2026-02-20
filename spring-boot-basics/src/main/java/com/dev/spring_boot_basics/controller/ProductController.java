package com.dev.spring_boot_basics.controller;

import com.dev.spring_boot_basics.dto.ProductResponseDto;
import com.dev.spring_boot_basics.model.Product;
import com.dev.spring_boot_basics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.List;

//@RestController is a specialized version of @Controller that automatically returns JSON (or other HTTP body content) instead of a view.
//@RequestMapping is a core annotation from the Spring Framework used to map HTTP requests to handler methods in a controller.
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }

    //@PathVariable is an annotation from the Spring Framework used to extract values directly from the URL path and bind them to method parameters.
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product product = service.getProductById(productId);

        if (product == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);
    }

    @SuppressWarnings("JvmTaintAnalysis")
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {

        System.out.println("Adding product: " + product);

        try {
            Product newProduct = service.addProduct(product, imageFile);

            //noinspection JvmTaintAnalysis
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ProductResponseDto(newProduct));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    //Never dereference a potentially null object before checking if it’s null.
    @GetMapping("products/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        Product product = service.getProductById(productId);
        if (product == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        byte[] imageFile = product.getImageData();
        if (imageFile == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @SuppressWarnings("JvmTaintAnalysis")
    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(
            @PathVariable int productId,
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile
    ) {

        if (service.getProductById(productId) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        try {
            Product newProduct = service.updateProduct(product, imageFile);
            //noinspection JvmTaintAnalysis
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ProductResponseDto(newProduct));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = service.getProductById(id);

        if (product == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        service.deleteProduct(id);

        return new ResponseEntity<>("Deleted", HttpStatus.OK);

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = service.searchProducts(keyword);
        System.out.println("searching with " + keyword);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }
}