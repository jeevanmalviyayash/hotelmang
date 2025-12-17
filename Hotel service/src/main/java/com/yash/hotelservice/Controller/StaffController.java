package com.yash.hotelservice.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/details")
    public ResponseEntity<String> getStaffDetails() {
        List<String> staffList = Arrays.asList("Ram", "Shyam", "Sita");
        return new ResponseEntity<>(staffList.toString(), HttpStatus.OK);
    }
}
