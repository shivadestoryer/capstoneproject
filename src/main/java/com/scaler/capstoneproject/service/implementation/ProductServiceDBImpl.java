package com.scaler.capstoneproject.service.implementation;

import com.scaler.capstoneproject.models.Product;
import com.scaler.capstoneproject.repository.ProductRepository;
import com.scaler.capstoneproject.service.ProductService;
import com.scaler.capstoneproject.service.ProductServiceDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceDBImpl implements ProductServiceDB {

    private final ProductRepository productRepository;

    ProductServiceDBImpl(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    @Override
    public Product findById(UUID id) {
        return null;
    }

    @Override
    public void addOrUpdateProduct(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
