package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.UserNotFoundException;
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
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) throws UserNotFoundException {
       User userObj = userRepository.findByUsernameAndPassword(username, password);
        if(userObj == null){
            throw new UserNotFoundException();
        }
         return userObj;
    }
}
