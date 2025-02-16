package com.scaler.capstoneproject.dto;

import lombok.Data;

@Data
public class FakeStoreProductDto {
    private long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @Data
    public class Rating {
        private double rate;
        private Integer count;
    }
}
