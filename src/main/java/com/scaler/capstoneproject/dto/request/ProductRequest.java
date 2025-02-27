package com.scaler.capstoneproject.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductRequest {
        private UUID sellerUuid;
        private String name;
        private String description;
        private String imageUrl;
        private String categoryName;
        private String createdBy;
        private LocalDateTime createdDate;
        private UUID uuid;
        private String modifiedBy;
        private LocalDateTime modifiedDate;
        private BigDecimal price;
        private Integer stockQuantity;
    }

