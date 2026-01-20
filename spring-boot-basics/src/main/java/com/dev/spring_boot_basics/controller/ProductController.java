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

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product product = service.getProductById(productId);

        if (product != null) {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(product);
        } else {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @SuppressWarnings("JvmTaintAnalysis")
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {

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

    @GetMapping("products/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {

        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageData();

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
        if (product != null) {
            service.deleteProduct(id);

            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Product not found");
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

//package com.dev.spring_boot_basics.controller;
//
//import com.dev.spring_boot_basics.model.Product;
//import com.dev.spring_boot_basics.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class ProductController {
//
//    ProductService productService;
//
//    @Autowired
//    public void setService(ProductService service) {
//        this.productService = service;
//    }
//
//    @GetMapping("/products")
//    public List<Product> getProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/products/{productId}")
//    public ResponseEntity<?> getProductById(@PathVariable int productId) {
//        Product product = productService.getProductById(productId);
//
//        if (product != null) {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(product);
//        } else {
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Product not found");
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(response);
//        }
//    }
//
//    @PostMapping("/products")
//    public ResponseEntity<?> addProduct(@RequestBody Product product) {
//        System.out.println("Adding product | controller: " + product);
//
//        boolean created = productService.addProduct(product);
//
//        if (created) {
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } else {
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Operation failed!");
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(response);
//        }
//    }
//
//    @PutMapping("/products/{productId}")
//    public ResponseEntity<?> updateProduct(@PathVariable int productId, @RequestBody Product product) {
//        System.out.println("Updating product | controller: " + productId);
//
//        boolean updated = productService.updateProductById(productId, product);
//
//        if (updated) {
//            return ResponseEntity.status(HttpStatus.OK).build();
//        } else {
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Operation failed!");
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(response);
//        }
//    }
//
//    @DeleteMapping("/products/{productId}")
//    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
//        System.out.println("Deleting productId | controller: " + productId);
//
//        boolean deleted = productService.deleteProductById(productId);
//
//        if (deleted) {
//            return ResponseEntity.status(HttpStatus.OK).build();
//        } else {
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Operation failed!");
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(response);
//        }
//    }
//}
