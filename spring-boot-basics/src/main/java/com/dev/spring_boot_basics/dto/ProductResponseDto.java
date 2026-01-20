package com.dev.spring_boot_basics.dto;

import com.dev.spring_boot_basics.model.Product;
import lombok.Getter;
import org.springframework.web.util.HtmlUtils;

import java.math.BigDecimal;
import java.util.Date;

@Getter
public class ProductResponseDto {
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;

    private String imageName;
    private String imageType;
    private byte[] imageData;

    public ProductResponseDto() {
    }

    public ProductResponseDto(Product p) {
        this.id = p.getId();
        this.name = HtmlUtils.htmlEscape(p.getName());
        this.description = HtmlUtils.htmlEscape(p.getDescription());
        this.brand = HtmlUtils.htmlEscape(p.getBrand());
        this.price = p.getPrice();
        this.category = HtmlUtils.htmlEscape(p.getCategory());
        this.releaseDate = p.getReleaseDate();
        this.available = p.isAvailable();
        this.quantity = p.getQuantity();
        this.imageName = HtmlUtils.htmlEscape(p.getImageName());
        this.imageType = HtmlUtils.htmlEscape(p.getImageType());
        this.imageData = p.getImageData();
    }
}
