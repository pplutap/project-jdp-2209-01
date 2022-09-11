package com.kodilla.ecommercee.api.controllers;


import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupAlreadyExistException;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.exceptions.InvalidObjectId;
import com.kodilla.ecommercee.exceptions.UnsafeDeleteAttemptException;
import com.kodilla.ecommercee.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getAllGroups () {
        return ResponseEntity.ok( groupService.getAllGroups());
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<GroupDto> getGroupById (@PathVariable Long groupId) throws GroupNotFoundException {
        return ResponseEntity.ok(groupService.getGroupById(groupId));
    }

    @DeleteMapping (value = "{groupId}")
    public ResponseEntity<Void> deleteGroupById (@PathVariable Long groupId)
                                                                throws  GroupNotFoundException,
                                                                        UnsafeDeleteAttemptException {
        groupService.deleteById(groupId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> createNewGroup (@RequestBody GroupDto groupDto)
                                                                throws GroupAlreadyExistException {
        return ResponseEntity.ok(groupService.addGroup(groupDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> updateGroup (@RequestBody GroupDto groupDto)
                                                                    throws InvalidObjectId,
                                                                           GroupNotFoundException {
        return ResponseEntity.ok( groupService.updateGroup(groupDto));
    }

}
