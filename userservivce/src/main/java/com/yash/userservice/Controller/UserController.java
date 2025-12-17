package com.yash.userservice.Controller;

import com.yash.userservice.entities.User;
import com.yash.userservice.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "User Management APIs",
        description = "APIs for managing User Data"
)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //To create a User

    @Operation(
            summary = "Save user details!",
            description = "It is a Save Controller which saves the User data from req"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status OK"
    )
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User req){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(req));
    }

    // To get the single user Get

    @Operation(
            summary = "Get User data from User Id!",
            description = "Its a controller which use getUserById to get the Data"

    )
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // To get all the users
    @Operation(
            summary = "Get AllUser data!",
            description = "Its a controller which use getAllUser AllUser users"

    )
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAlluser();
        return ResponseEntity.ok(allUser);
    }
}
