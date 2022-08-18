package com.kodilla.ecommercee;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/groups")
public class GroupController {

    @GetMapping
    public ResponseEntity<String> getAllGroups () {
        return ResponseEntity.ok("List of groups");
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<String> getGroupById (@PathVariable Long groupId) {
        return  ResponseEntity.ok("Selected group with id: " + groupId);
    }

    @DeleteMapping (value = "{groupId}")
    public ResponseEntity<String> deleteGroupById (@PathVariable Long groupId) {
        return ResponseEntity.ok("Deleting group by ID: " + groupId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNewGroup (@RequestBody String groupDto) {
        return ResponseEntity.ok("New group created" + groupDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateGroup (@RequestBody String groupDto) {
        return ResponseEntity.ok("Group updated" + groupDto);
    }

}
