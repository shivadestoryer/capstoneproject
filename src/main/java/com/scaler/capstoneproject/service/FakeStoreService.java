package com.scaler.capstoneproject.service;

import com.scaler.capstoneproject.dto.FakeStoreProductDto;

public interface FakeStoreService {

    FakeStoreProductDto getProductById(long id);
}
