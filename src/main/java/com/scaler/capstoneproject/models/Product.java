package com.scaler.capstoneproject.models;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private String url;
    private Double price;
    private Category category;


}
