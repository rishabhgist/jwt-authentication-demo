package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }
}
