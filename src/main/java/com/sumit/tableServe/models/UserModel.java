package com.sumit.tableServe.models;


import com.sumit.tableServe.enus.Roles;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("users")
@Data
public class UserModel {

    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    @Indexed(unique = true)
    private String email;
    private String username;
    @NonNull
    private String password;
    @NonNull
    @Indexed(unique = true)
    private String phone;
    private String address;
    private Roles role = Roles.OWNER;
    private LocalDateTime createdAt = LocalDateTime.now();

}
