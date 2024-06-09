package com.friends.backend.service.serviceImpl;

import com.friends.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.friends.backend.dto.UserForm;
import com.friends.backend.entity.Person;
import com.friends.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void createUser(UserForm userForm) {
        // Create user entity
        Person user = new Person();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setUsername(userForm.getUsername());
        user.setPassword("password");
        System.out.println("Saving");
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserForm getUserById(Long userId) {
        // Fetch user entity by userId
        Person user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Map user entity to UserForm and return
        UserForm userForm = new UserForm();
        userForm.setFirstName(user.getFirstName());
        userForm.setLastName(user.getLastName());
        userForm.setUsername(user.getUsername());
        return userForm;
    }

    @Override
    @Transactional
    public void updateUser(Long userId, UserForm userForm) {
        // Fetch user entity by userId
        Person user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Update user entity with new data from userForm
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setUsername(userForm.getUsername());
        // Save updated user entity
        userRepository.save(user);
    }
}
