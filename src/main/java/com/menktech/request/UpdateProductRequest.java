package com.menktech.request;

import com.menktech.status.ProductStatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UpdateProductRequest {

    @NotBlank
    private String name;

    @Length(max = 250)
    private String description;

    @Length(max = 200)
    private String purchaseLink;

    private String category;

    private String brand;

    private String price;

    private ProductStatusEnum status;

}
