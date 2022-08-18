package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<String> getAllUsers(){
        return ResponseEntity.ok("Should return list of all users");
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<String> getUserById(@PathVariable long userId){
        return ResponseEntity.ok("Should return user with Id: " + userId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postUser(@RequestBody String userInfo){
        return ResponseEntity.ok("Shout post new user. " + userInfo);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody String userInfo){
        return ResponseEntity.ok("Shout update user. " + userInfo);
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId){
        return ResponseEntity.ok("Should delete user with Id: " + userId);
    }

}
