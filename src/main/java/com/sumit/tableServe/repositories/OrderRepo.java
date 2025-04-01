package com.sumit.tableServe.repositories;

import com.sumit.tableServe.models.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepo extends MongoRepository<OrderModel, String> {

    public List<OrderModel> findByShopId(String shopId);

    public OrderModel findByOrderId(String orderId);
}
