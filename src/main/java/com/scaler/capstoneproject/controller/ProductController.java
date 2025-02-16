package com.scaler.capstoneproject.controller;

import com.scaler.capstoneproject.dto.response.ProductResponse;
import com.scaler.capstoneproject.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable long id)
    {
       ProductResponse productResponse= productService.findById(id);
       return  ResponseEntity.ok(productResponse);
    }



}
