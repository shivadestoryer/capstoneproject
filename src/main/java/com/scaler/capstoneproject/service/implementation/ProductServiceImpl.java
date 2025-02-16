package com.scaler.capstoneproject.service.implementation;


import com.scaler.capstoneproject.dto.FakeStoreProductDto;
import com.scaler.capstoneproject.dto.response.ProductResponse;
import com.scaler.capstoneproject.dto.response.Rating;
import com.scaler.capstoneproject.service.FakeStoreService;
import com.scaler.capstoneproject.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    private final FakeStoreService fakeStoreService;

    @Autowired
    ProductServiceImpl(FakeStoreService fakeStoreService) {
        this.fakeStoreService = fakeStoreService;
    }


    @Override
    public ProductResponse findById(long id) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreService.getProductById(id);
        return buildProductResponse(fakeStoreProductDto);
    }

    private ProductResponse buildProductResponse(FakeStoreProductDto fakeStoreProductDto) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(fakeStoreProductDto, productResponse);
        buildRatings(productResponse, fakeStoreProductDto);
        return productResponse;
    }

    private void buildRatings(ProductResponse productResponse, FakeStoreProductDto fakeStoreProductDto) {
        Rating rating = new Rating();
        rating.setRate(fakeStoreProductDto.getRating().getRate());
        rating.setCount(fakeStoreProductDto.getRating().getCount());
        productResponse.setRating(rating);
    }


}
