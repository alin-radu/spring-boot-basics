package com.dev.spring_boot_basics.service;

import com.dev.spring_boot_basics.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ProductService {

    List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Car", 1000),
            new Product(2, "House", 500000)

    ));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst().orElse(null);
    }

    public boolean addProduct(Product product) {
        System.out.println("Adding product | service: " + product);

        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            return false;
        }

        products.add(product);
        return true;
    }
    public boolean updateProductById(int productId, Product product) {
        System.out.println("Updating product | service: " + product);

        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            return false;
        }

        boolean result = false;

        for (Product p : products) {
            if (p.getProductId() == productId) {
                p.setProductName(product.getProductName());
                p.setPrice(product.getPrice());

                result = true;
                break;
            }
        }

        return result;
    }
    public boolean deleteProductById(int productId) {
        System.out.println("Deleting productId | service: " + productId);

        var iterator = products.iterator();

        boolean result = false;
        while (iterator.hasNext()) {
            var product = iterator.next();
            if (product.getProductId() == productId) {
                iterator.remove();

                result = true;
                break;
            }
        }

        return result;
    }
}

//package com.dev.spring_boot_basics.service;
//
//import com.dev.spring_boot_basics.model.Product;
//import com.dev.spring_boot_basics.repo.ProductRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    private ProductRepo repo;
//
//    @Autowired
//    public void setRepo(ProductRepo repo) {
//        this.repo = repo;
//    }
//
//    public List<Product> getAllProducts() {
//        return repo.findAll();
//    }
//
//    public Product getProductById(int productId) {
//        return repo.findById(productId).orElse(null);
//    }
//    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageType(imageFile.getContentType());
//        product.setImageData(imageFile.getBytes());
//
//        return repo.save(product);
//    }
//
//    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {
//        product.setImageData(imageFile.getBytes());
//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageType(imageFile.getContentType());
//       return repo.save(product);
//    }
//
//    public void deleteProduct(int id) {
//        repo.deleteById(id);
//    }
//
//    public List<Product> searchProducts(String keyword) {
//        return repo.searchProducts(keyword);
//    }
//}
