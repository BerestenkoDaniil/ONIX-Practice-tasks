package com.example.onixpractice.services;

import com.example.onixpractice.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onixpractice.controller.EmailController;
import com.example.onixpractice.controller.UserController;
import com.example.onixpractice.controller.CronJobController;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(String username, String email);
    Optional<User> updateUser(Long id, String username, String email);
    void deleteUser(Long id);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);

    User editUser(Long userId, String username, String email);
}

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setCreatedOn(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, String username, String email) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(user -> {
            user.setUsername(username);
            user.setEmail(email);
            userRepository.save(user);
        });
        return optionalUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}