package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mappers.UserMapper;
import com.kodilla.ecommercee.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.ecommercee.mappers.UserMapper.mapToDto;
import static com.kodilla.ecommercee.mappers.UserMapper.mapToUser;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) throws UserNotFoundException {

        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return mapToDto(user);
    }

    public UserDto createUser(UserDto userDto) {

        User savedUser = userRepository.save(mapToUser(userDto));
        return mapToDto(savedUser);
    }

    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        if(!userRepository.existsById(userDto.getId()))
            throw new UserNotFoundException();

        User savedUser = userRepository.save(mapToUser(userDto));
        return mapToDto(savedUser);
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        if(!userRepository.existsById(id))
            throw new UserNotFoundException();

        userRepository.deleteById(id);
    }
}