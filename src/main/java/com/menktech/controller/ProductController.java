package com.menktech.controller;

import com.menktech.entity.Product;
import com.menktech.request.CreateProductRequest;
import com.menktech.request.UpdateProductRequest;
import com.menktech.response.CreateProductResponse;
import com.menktech.response.UpdateProductResponse;
import com.menktech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> addProduct(@RequestBody CreateProductRequest request){

        Product newProduct = productService.addProduct(request);

        CreateProductResponse response = CreateProductResponse.createFromProduct(newProduct);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductResponse> updateProduct (@PathVariable Long id, @RequestBody UpdateProductRequest request ){

        Product updatedProduct = productService.updateProduct(id, request);

        UpdateProductResponse response = UpdateProductResponse.fromProduct(updatedProduct);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id){

        productService.deleteProduct(id);


    }
}
