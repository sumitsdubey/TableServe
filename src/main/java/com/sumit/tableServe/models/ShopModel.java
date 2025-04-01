package com.sumit.tableServe.models;

import com.sumit.tableServe.enus.Status;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("shops")
public class ShopModel {
    @Id
    private String shopId;

    @Indexed(unique = true)
    private String username;
    @NonNull
    private String shopName;
    @NonNull
    private String shopAddress;
    @NonNull
    private String shopCity;
    @NonNull
    private String idenity;
    @NonNull
    private String phone;
    private String email;

    @DBRef
    private List<ItemModel> items= new ArrayList<>();

    private String image;
    private String description;
    private Status status= Status.PENDING;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
