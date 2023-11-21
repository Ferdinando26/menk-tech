package com.menktech.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank(message = "The product must have a name")
    private String name;

    @Length(max = 250)
    private String description;

    @NotNull
    private String purchaseLink;

    @NotBlank(message = "The product must have a category")
    private String category;

    private String brand;

}
