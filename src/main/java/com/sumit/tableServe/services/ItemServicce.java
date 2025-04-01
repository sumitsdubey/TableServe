package com.sumit.tableServe.services;
import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.ItemModel;
import com.sumit.tableServe.models.ShopModel;
import com.sumit.tableServe.repositories.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServicce {

    private static final Logger log = LoggerFactory.getLogger(ItemServicce.class);
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ShopServices shopServices;


    public ApiResponseModel saveItem(ItemModel item, String username) {
        try{

            ShopModel shop = shopServices.getShopbyUsername(username);
            if(shop !=null) {

                String itemName = item.getItemName();

                ItemModel itemexist = getItemByName(itemName);

                if (itemexist != null) {
                    shop.getItems().add(itemexist);
                } else {
                    ItemModel saved = itemRepo.save(item);
                    shop.getItems().add(saved);
                }
                shopServices.updateShop(shop);

                return new ApiResponseModel("NO CONTENT", "Item Added Success", 201, true);
            }

            return new ApiResponseModel(null,"Unauthorized Request", 401, false);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public ItemModel getItemByName(String name) {
        return itemRepo.findByItemName(name);
    }


}
