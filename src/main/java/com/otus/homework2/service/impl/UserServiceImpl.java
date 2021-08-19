package com.otus.homework2.service.impl;

import com.otus.homework2.model.User;
import com.otus.homework2.repository.UserRepository;
import com.otus.homework2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User getUser(int id) {
        User user;
        user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
        return user;
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(
            int userId,
            String firstName,
            String lastName,
            String email,
            String phone
    ) {
        User user = getUser(userId);
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        saveUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
