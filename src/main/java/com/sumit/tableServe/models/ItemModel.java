package com.sumit.tableServe.models;

import com.sumit.tableServe.enus.Availability;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("items")
public class ItemModel {

    @Id
    private String itemId;
    @NonNull
    private String itemName;
    private String itemDescription;
    @NonNull
    private String price;
    private String quantity;
    private String category;
    private String image;
    private Availability availability;

}
