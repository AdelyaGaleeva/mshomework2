package com.otus.homework2.controller;

import com.otus.homework2.dto.UserCreateDto;
import com.otus.homework2.dto.UserDto;
import com.otus.homework2.dto.UserUpdatedDto;
import com.otus.homework2.mapper.UserMapper;
import com.otus.homework2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Записи разговоров с гостем", description = "Записи разговоров с гостем")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(
            summary = "Получить профиль пользователя по id",
            description = "Метод по заданному идентификатору пользователя возвращает его профиль, если он найден."
    )
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int userId) {
        return ResponseEntity.ok(userMapper.toUserDto(userService.getUser(userId)));
    }

    @Operation(
            summary = "Создание профиля пользователя",
            description = "Метод позволяет создать профиль пользователя."
    )
    @PostMapping
    public void createUser(@RequestBody UserCreateDto userCreateDto) {
        userService.saveUser(userMapper.toUser(userCreateDto));
    }

    @Operation(
            summary = "Обновление профиля пользователя",
            description = "Метод позволяет обновить профиль пользователя."
    )
    @PutMapping("/{userId}")
    public void createUser(@PathVariable int userId, @RequestBody UserUpdatedDto userUpdateDto) {
        userService.updateUser(userId, userUpdateDto.getFirstName(), userUpdateDto.getLastName(),
                userUpdateDto.getEmail(), userUpdateDto.getPhone());
    }

    @Operation(
            summary = "Удалить пользователя по id",
            description = "Метод позволяет удалить пользователя по id"
    )
    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
