package com.otus.homework2.service;

import com.otus.homework2.model.User;

public interface UserService {

    User getUser(int id);

    void saveUser(User user);

    void updateUser(int userId,
                    String firstName,
                    String lastName,
                    String email,
                    String phone);

    void deleteUser(int id);
}
