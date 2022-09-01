package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final List<UserDto> USERS = Arrays.asList(
            new UserDto(1,"Piotr", "1",59403),
            new UserDto(2,"Admin", "1",96997),
            new UserDto(3,"User", "0",31251)
    );

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(USERS);
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long userId){

        return ResponseEntity.ok(new UserDto(userId, "Test user", "1", 131313));

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
