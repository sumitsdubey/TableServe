package com.sumit.tableServe.controllers;

import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.ShopModel;
import com.sumit.tableServe.services.ShopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopServices shopServices;

    @PostMapping("/{username}/create")
    public ResponseEntity<?> saveShop(@RequestBody ShopModel shop, @PathVariable String username) {
        ApiResponseModel response = shopServices.saveShop(shop, username);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getShop(@PathVariable String username) {
        ShopModel shop = shopServices.getShopbyUsername(username);
        if(shop != null) {
            return new ResponseEntity<>(shop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    ******************* UPDATE SHOP DETAILS***************

    @PutMapping("/{username}/update")
    public ResponseEntity<?> updateShop(@RequestBody ShopModel shop, @PathVariable String username) {
        ApiResponseModel response = shopServices.saveShop(shop, username);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
