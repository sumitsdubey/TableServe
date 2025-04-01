package com.sumit.tableServe.repositories;

import com.sumit.tableServe.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserModel,String> {

    public UserModel findByUsername(String username);
}
