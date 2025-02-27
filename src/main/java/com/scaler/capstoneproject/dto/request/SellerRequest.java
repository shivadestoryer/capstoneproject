package com.scaler.capstoneproject.dto.request;

import com.scaler.capstoneproject.models.Seller;
import lombok.*;

import java.util.UUID;

@Data
public class SellerRequest {

    private UUID uuid;
    private String name;
    private String address;
    private String emailId;
    private String phoneNumber;
    private String gstNumber;
    private String pan;
    private String bankAccountNumber;
}
