package com.kodilla.ecommercee.api.controllers;

import com.kodilla.ecommercee.domain.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final List<UserDTO> USERS = Arrays.asList(
            new UserDTO(1,"Piotr", "1",59403),
            new UserDTO(2,"Admin", "1",96997),
            new UserDTO(3,"User", "0",31251)
    );

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(USERS);
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long userId){

        return ResponseEntity.ok(new UserDTO(userId, "Test user", "1", 131313));

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postUser(@RequestBody String userInfo){
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestBody String userInfo){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId){
        return ResponseEntity.ok().build();
    }

}
