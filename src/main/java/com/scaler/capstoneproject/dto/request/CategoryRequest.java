package com.scaler.capstoneproject.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryRequest {
    private String name;
    private UUID id;

}
