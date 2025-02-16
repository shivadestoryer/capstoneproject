package com.scaler.capstoneproject.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductResponse {
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;



}
