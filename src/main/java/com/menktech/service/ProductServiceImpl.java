package com.menktech.service;

import com.menktech.entity.Product;
import com.menktech.repository.IProductRepository;
import com.menktech.request.CreateProductRequest;
import com.menktech.request.UpdateProductRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> getAllProducts(){
        return this.iProductRepository.findAll();
    }

    public Product getProductById(Long id){
        Optional<Product> optionalProduct = iProductRepository.findProductById(id);
        return optionalProduct.orElse(null);
    }

    public Product addProduct(CreateProductRequest request){

        Product product = Product.fromCreateRequest(request);
        return this.iProductRepository.save(product);
    }


    public Product updateProduct(Long id, UpdateProductRequest request) {

        Product existingProduct = iProductRepository.getReferenceById(id);

        existingProduct.updateProductDetails(request);

        return this.iProductRepository.save(existingProduct);
    }

    public void deleteProduct(Long id){
        iProductRepository.deleteById(id);
    }
}
