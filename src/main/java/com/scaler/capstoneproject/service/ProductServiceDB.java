package com.scaler.capstoneproject.service;

import com.scaler.capstoneproject.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductServiceDB {

    Product findById(UUID id);
    void addOrUpdateProduct(Product product);
    List<Product> findAll();

}
