package com.sumit.tableServe.services;

import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.UserModel;
import com.sumit.tableServe.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

//    INTANCE OF USER REPOSITORY
    @Autowired
    private UserRepo userRepo;

    //THIS IS METHOD TO CREATE A NEW USER. IT RETURNS CUSTOM RESPONSE MODEL
    public ApiResponseModel saveUser(UserModel user) {
        String username = user.getEmail().toLowerCase().split("@")[0];
        user.setUsername(username);
        UserModel saved = userRepo.save(user);
        if(saved != null) {
            return new ApiResponseModel(saved,"User Saved Success", 201, true);
        }
        return new ApiResponseModel(null,"User Saved Error", 500, false);
    }

    //THIS IS METHOD TO GET A USER BY USERNAME.IT WILL RETURN A USER MODEL
    public UserModel getUser(String username) {
        return userRepo.findByUsername(username);
    }


    //THIS METHOD TO UPDATE THE USER AND WILL RETURN CUSTOM RESPONSE MODEL
    public ApiResponseModel updateUser(UserModel user) {
        UserModel saved = userRepo.save(user);
        if(saved != null) {
            return new ApiResponseModel("NO CONTENT","User Updated Success", 201, true);
        }
        return new ApiResponseModel("NO CONTENT","User Updated Error", 500, false);
    }
}
