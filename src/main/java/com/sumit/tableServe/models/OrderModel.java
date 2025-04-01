package com.sumit.tableServe.models;

import com.sumit.tableServe.enus.OrderStatus;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "orders")
@Data
public class OrderModel {

    @Id
    private String orderId;
    @NonNull
    private String customerName;
    @NonNull
    private String customerMobile;
    @NonNull
    private String itemId;
    @NonNull
    private String shopId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;


}
