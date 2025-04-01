package com.sumit.tableServe.services;

import com.sumit.tableServe.enus.OrderStatus;
import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.OrderModel;
import com.sumit.tableServe.repositories.ItemRepo;
import com.sumit.tableServe.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ItemRepo itemRepo;

    public ApiResponseModel addOrder(OrderModel order) {
        OrderModel saved = orderRepo.save(order);
        if (saved != null) {
            return new ApiResponseModel(saved, "Order Added Success", 201, true);
        }
        return new ApiResponseModel("NO CONTENT", "Order Not Added", 400, false);
    }

    //********** THIS METHOD RETURNS LIST OF ORDERS OF ANY SHOP***********

    public ApiResponseModel getAllOrdersByShopId(String shopId) {
        try {
            List<OrderModel> orders = orderRepo.findByShopId(shopId);
            if(orders.size() > 0) {
                return new ApiResponseModel(orders, "Order List", 200, true);
            }
            return new ApiResponseModel("NO CONTENT", "No Orders Found", 400, false);

        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // *************** THIS METHOD FOR UPDATE ORDER STATUS************
    public ApiResponseModel updateOrderStatus(String orderId, String status) {
        try{
            OrderModel order = orderRepo.findByOrderId(orderId);
            if(order != null) {
                order.setOrderStatus(OrderStatus.valueOf(status));
                orderRepo.save(order);
                return new ApiResponseModel(order, "Order Updated Success", 201, true);
            }
            return new ApiResponseModel("NO CONTENT", "Order Not Updated", 401, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    // ************** GET ORDER BY ID****************
    public ApiResponseModel getOrderById(String orderId) {
        try{
            OrderModel order = orderRepo.findByOrderId(orderId);
            if(order != null) {
                return new ApiResponseModel(order, "Order List", 200, true);
            }
            return new ApiResponseModel("NO CONTENT", "No Orders Found", 404, false);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
