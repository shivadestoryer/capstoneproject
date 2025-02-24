package com.scaler.capstoneproject.controller;

import com.scaler.capstoneproject.dto.request.CategoryRequest;
import com.scaler.capstoneproject.dto.request.ProductRequest;
import com.scaler.capstoneproject.dto.request.SellerRequest;
import com.scaler.capstoneproject.dto.response.ProductResponse;
import com.scaler.capstoneproject.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value="")
    public ResponseEntity createOrUpdateProduct(@RequestBody ProductRequest productRequest )
    {

        return ResponseEntity.accepted().build();
    }

    @PutMapping(value="/seller")
    public ResponseEntity createOrUpdateProduct(@RequestBody SellerRequest productRequest ) {

        return ResponseEntity.accepted().build();
    }


    @PutMapping(value="/category")
    public ResponseEntity createOrUpdateProduct(@RequestBody CategoryRequest productRequest ) {

        return ResponseEntity.accepted().build();
    }






    }
