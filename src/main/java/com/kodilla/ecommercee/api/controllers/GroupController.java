package com.kodilla.ecommercee.api.controllers;


import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/groups")
public class GroupController {

    @GetMapping
    public ResponseEntity<List<GroupDto>> getAllGroups () {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<GroupDto> getGroupById (@PathVariable Long groupId) {
        return ResponseEntity.ok(new GroupDto(1,"Test name"));
    }

    @DeleteMapping (value = "{groupId}")
    public ResponseEntity<Void> deleteGroupById (@PathVariable Long groupId) {
        return ResponseEntity.ok().build(); //groupNotFoundException do dodania
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewGroup (@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> updateGroup (@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(new GroupDto(1, "Test name"));
    }

}
