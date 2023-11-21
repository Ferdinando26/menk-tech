package com.menktech.response;

import com.menktech.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateProductResponse {

    private Long id;
    private String name;
    private String description;
    private String purchaseLink;
    private String category;


    public static CreateProductResponse createFromProduct(Product createProduct) {

        return CreateProductResponse.builder()
                .id(createProduct.getId())
                .name(createProduct.getName())
                .description(createProduct.getDescription())
                .category(createProduct.getCategory())
                .purchaseLink(createProduct.getPurchaseLink())
                .build();
    }

}
