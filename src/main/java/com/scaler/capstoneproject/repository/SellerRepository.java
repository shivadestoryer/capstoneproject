package com.scaler.capstoneproject.repository;

import com.scaler.capstoneproject.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
    @Query(value = "SELECT * FROM seller WHERE uuid = :sellerUuid", nativeQuery = true)
    Seller findByUuid(@Param("sellerUuid") String sellerUuid);
}
