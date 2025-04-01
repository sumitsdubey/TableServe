package com.sumit.tableServe.services;

import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.ShopModel;
import com.sumit.tableServe.models.UserModel;
import com.sumit.tableServe.repositories.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShopServices {


    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private UserService userService;


    public ApiResponseModel saveShop(ShopModel shop, String username) {
        try{
            UserModel user = userService.getUser(username);
            if(user == null) {
                return new ApiResponseModel(null, "UnAuthorized to Create Shop", 401, false);
            }

            shop.setUsername(username);
            shop.setCreatedAt(LocalDateTime.now());
            ShopModel saved = shopRepo.save(shop);
            if(saved != null) {
                return new ApiResponseModel(saved, "Data Saved Success", 201, true);
            }
            return new ApiResponseModel(null,"Data Saved Failed", 500, false);
        }
        catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateShop(ShopModel shop) {
        shopRepo.save(shop);
    }


    public ShopModel getShopbyUsername(String username) {
        try{
            ShopModel shop = shopRepo.findByUsername(username);
           return shop;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
