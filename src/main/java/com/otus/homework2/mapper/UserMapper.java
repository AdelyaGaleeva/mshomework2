package com.otus.homework2.mapper;

import com.otus.homework2.dto.UserCreateDto;
import com.otus.homework2.dto.UserDto;
import com.otus.homework2.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserCreateDto userCreateDto) {
        var user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setEmail(userCreateDto.getEmail());
        user.setPhone(userCreateDto.getPhone());
        return user;
    }

    public UserDto toUserDto(User user) {
        var userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        return userDto;
    }
}
