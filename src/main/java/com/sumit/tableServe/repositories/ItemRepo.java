package com.sumit.tableServe.repositories;

import com.sumit.tableServe.models.ItemModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<ItemModel, String> {

    public ItemModel findByItemName(String name);

}
