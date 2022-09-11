package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupAlreadyExistException;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.exceptions.InvalidObjectId;
import com.kodilla.ecommercee.exceptions.UnsafeDeleteAttemptException;
import com.kodilla.ecommercee.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.ecommercee.mappers.GroupMapper.mapToDto;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<GroupDto> getAllGroups(){
        Iterable<Group> groups = groupRepository.findAll();
        List<GroupDto> groupDtos = new ArrayList<>();
        groups.forEach(group ->  groupDtos.add(mapToDto(group)));

        return groupDtos;
    }

    public GroupDto getGroupById(Long id) throws GroupNotFoundException {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);

        return mapToDto(group);
    }

    @Transactional
    public void deleteById(Long id) throws GroupNotFoundException, UnsafeDeleteAttemptException {
        if (!groupRepository.existsById(id))
            throw new GroupNotFoundException();

        if (groupRepository.safeDelete(id) == 0)
            throw new UnsafeDeleteAttemptException();
    }

    @Transactional
    public GroupDto addGroup(GroupDto groupToBeAdded) throws GroupAlreadyExistException {
        if(groupRepository.findGroupByName(groupToBeAdded.getName()).isPresent())
            throw new GroupAlreadyExistException();

        Group savedGroup = groupRepository.save(new Group(null, groupToBeAdded.getName()));

        return mapToDto(savedGroup);
    }

    @Transactional
    public GroupDto updateGroup(GroupDto groupDto) throws InvalidObjectId,
                                                          GroupNotFoundException {

        if (groupDto.getId()==null)
            throw new InvalidObjectId();

        Group group = groupRepository.findById(groupDto.getId())
                                     .orElseThrow(GroupNotFoundException::new);

        group.setName(groupDto.getName());
        groupRepository.save(group);

        return mapToDto(group);
    }

}
