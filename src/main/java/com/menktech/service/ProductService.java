package com.menktech.service;

import com.menktech.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
