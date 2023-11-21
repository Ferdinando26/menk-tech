package com.menktech.entity;

import com.menktech.request.CreateProductRequest;
import com.menktech.request.UpdateProductRequest;
import com.menktech.response.CreateProductResponse;
import com.menktech.status.ProductStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Data
@Getter
@Setter
@Builder
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    public Product(Long id, String name, String description, String purchaseLink, String category, String brand, String price, ProductStatusEnum status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purchaseLink = purchaseLink;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.status = status;
    }

    public Product() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String purchaseLink;

    @Column
    private String category;

    @Column
    private String brand;

    @Column
    private String price;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum status;

    public static Product fromCreateRequest(CreateProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .purchaseLink(request.getPurchaseLink())
                .category(request.getCategory())
                .brand(request.getBrand())
                .build();
    }

    public void updateProductDetails(UpdateProductRequest request) {

        if (request != null) {

            this.setName(request.getName());
            this.setDescription(request.getDescription());
            this.setPurchaseLink(request.getPurchaseLink());
            this.setCategory(request.getCategory());
            this.setBrand(request.getBrand());
            this.setPrice(request.getPrice());
            this.setStatus(request.getStatus());
        }
    }


}
