package com.scaler.capstoneproject.models;

import com.scaler.capstoneproject.dto.request.SellerRequest;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "seller")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "email_id", nullable = false, unique = true, length = 255)
    private String emailId;

    @Column(name = "phone_number", length = 20, unique = true)
    private String phoneNumber;


    private Status status = Status.ACTIVE;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "modified_by")
    private UUID modifiedBy;

    @Column(name = "created_date", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdDate;

    @Column(name = "modified_date", insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp modifiedDate;

    @Column(name = "gst_number", length = 500)
    private String gstNumber;

    @Column(name = "pan", length = 500)
    private String pan;

    @Column(name = "bank_account_number", length = 500)
    private String bankAccountNumber;

    @OneToMany(mappedBy = "seller")
    private List<SellerProduct> sellerProductList;

    public Seller(SellerRequest sellerRequest)
    {
        this.name = sellerRequest.getName();
        this.address = sellerRequest.getAddress();
        this.emailId = sellerRequest.getEmailId();
        this.phoneNumber = sellerRequest.getPhoneNumber();
        this.gstNumber = sellerRequest.getGstNumber();
        this.pan = sellerRequest.getPan();
        this.bankAccountNumber = sellerRequest.getBankAccountNumber();
    }


    public enum Status {
        ACTIVE, INACTIVE, SUSPENDED
    }
}
