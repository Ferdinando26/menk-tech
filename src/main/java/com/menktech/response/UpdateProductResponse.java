package com.menktech.response;

import com.menktech.entity.Product;
import com.menktech.status.ProductStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateProductResponse {


    private Long id;
    private String name;
    private String description;
    private String purchaseLink;
    private String category;
    private String brand;
    private String price;
    private ProductStatusEnum status;

    public static UpdateProductResponse fromProduct(Product updatedProduct) {
        return UpdateProductResponse.builder()
                .id(updatedProduct.getId())
                .name(updatedProduct.getName())
                .description(updatedProduct.getDescription())
                .category(updatedProduct.getCategory())
                .brand(updatedProduct.getBrand())
                .price(updatedProduct.getPrice())
                .purchaseLink(updatedProduct.getPurchaseLink())
                .status(updatedProduct.getStatus())
                .build();
    }

}
