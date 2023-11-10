package com.menktech.service;

import com.menktech.entity.Product;
import com.menktech.repository.IProductRepository;
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
        Optional<Product> product = iProductRepository.findById(id);
        return product.orElse(null);
    }

    public Product addProduct(Product product){
        return iProductRepository.save(product);
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = iProductRepository.findById(id).orElse(null);
        if (existingProduct != null){

            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPurchaseLink(product.getPurchaseLink());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setModel(product.getModel());
            existingProduct.setPrice(product.getPrice());

            return iProductRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(Long id){
        iProductRepository.deleteById(id);
    }

}
