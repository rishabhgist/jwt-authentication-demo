package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User save(User user);

    User getByUsernameAndPassword(String username, String password) throws UserNotFoundException;
}
