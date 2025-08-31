package com.example.journalapp.controller;


import com.example.journalapp.entity.User;
import com.example.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAll(){
        List<User> all = userService.getAll();
        if(all!=null && !all.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(all);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users");
    }
    @PostMapping("/create-admin-user")
    public ResponseEntity<?> createAdmin(@RequestBody User user){
        User user1 = userService.saveAdmin(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Admin user created");
    }
}
