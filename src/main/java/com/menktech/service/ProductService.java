package com.menktech.service;

import com.menktech.entity.Product;
import com.menktech.request.CreateProductRequest;
import com.menktech.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(CreateProductRequest request);
    Product updateProduct(Long id, UpdateProductRequest request);
    void deleteProduct(Long id);
}
