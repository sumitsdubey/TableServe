package com.sumit.tableServe.controllers;

import com.sumit.tableServe.enus.OrderStatus;
import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.OrderModel;
import com.sumit.tableServe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> addOrder(@RequestBody OrderModel order) {
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PENDING);
        ApiResponseModel response = orderService.addOrder(order);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all/{shopId}")
    public ResponseEntity<?> getAllOrders(@PathVariable String shopId) {
        ApiResponseModel response = orderService.getAllOrdersByShopId(shopId);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<?> updateOrderStatus(@RequestParam String status, @PathVariable String orderId) {
        ApiResponseModel response = orderService.updateOrderStatus(orderId, status);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);     
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable String orderId) {
        ApiResponseModel response = orderService.getOrderById(orderId);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
