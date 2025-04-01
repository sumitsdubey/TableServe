package com.sumit.tableServe.controllers;

import com.sumit.tableServe.models.ApiResponseModel;
import com.sumit.tableServe.models.UserModel;
import com.sumit.tableServe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//******************************THIS IS USER CONTROLLER***************************
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//**********************GETTING USER BY USERNAME******************
    @GetMapping("/{username}")
    public ResponseEntity<UserModel> getUser(@PathVariable String username) {
        UserModel user = userService.getUser(username);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
// ***************************** CREATE NEW USER ***************************
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserModel user) {
        ApiResponseModel response = userService.saveUser(user);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    ************************** UPDATE USER *************************
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserModel user) {
        ApiResponseModel response = userService.updateUser(user);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
