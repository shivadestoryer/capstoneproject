package com.scaler.capstoneproject.service;

import com.scaler.capstoneproject.dto.request.CategoryRequest;
import com.scaler.capstoneproject.dto.request.ProductRequest;
import com.scaler.capstoneproject.dto.request.SellerRequest;
import com.scaler.capstoneproject.dto.response.ProductResponse;
import com.scaler.capstoneproject.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {


    ProductResponse findById(long id);
    Product findById(UUID id);
    void addOrUpdateProduct(Product product);
    List<Product> findAll();

    void createOrUpdateCategory(CategoryRequest request);

    void createOrUpdateSeller(SellerRequest request);

    void createOrUpdateProduct(ProductRequest request);
}
