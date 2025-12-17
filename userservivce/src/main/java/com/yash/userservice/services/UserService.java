package com.yash.userservice.services;

import com.yash.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // user operations

    User saveUser(User user);

    //get all user
    List<User> getAlluser();

    //get user by id
    User getUser(String userId);
}
