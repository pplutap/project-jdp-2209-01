package com.kodilla.ecommercee;

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

        List<UserDTO> usersWithMatchingId= USERS.stream().filter(userDTO -> userDTO.getId() == userId)
                .collect(Collectors.toList());

        if(usersWithMatchingId.size()==1)
            return ResponseEntity.ok(usersWithMatchingId.get(0));
        else return null; //TODO dopisać GlobalHTTPErrorHandler i rzucic bład

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
