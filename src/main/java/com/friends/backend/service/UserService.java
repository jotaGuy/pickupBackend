package com.friends.backend.service;

import com.friends.backend.dto.UserForm;

public interface UserService {
    void createUser(UserForm userForm);
    UserForm getUserById(Long userId);
    void updateUser(Long userId, UserForm userForm);
}

