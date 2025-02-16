package com.scaler.capstoneproject.service;

import com.scaler.capstoneproject.dto.response.ProductResponse;

public interface ProductService {


    ProductResponse findById(long id);
}
