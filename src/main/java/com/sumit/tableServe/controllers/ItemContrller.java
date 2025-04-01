package com.sumit.tableServe.controllers;

import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.ItemModel;
import com.sumit.tableServe.services.ItemServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemContrller {

    @Autowired
    private ItemServicce itemServicce;


    @PostMapping("/{username}/create")
    public ResponseEntity<?> createItem(@RequestBody ItemModel item, @PathVariable String username) {
        ApiResponseModel response = itemServicce.saveItem(item, username);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
