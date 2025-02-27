package com.scaler.capstoneproject.models;
import lombok.Data;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String imageUrl;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String createdBy;

    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID uuid = UUID.randomUUID();

    private String modifiedBy;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "product")
    private List<SellerProduct> sellerProductList;


}
