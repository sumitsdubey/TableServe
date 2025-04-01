package com.sumit.tableServe.repositories;

import com.sumit.tableServe.models.ShopModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepo extends MongoRepository<ShopModel, String> {

    public ShopModel findByUsername(String username);

}
