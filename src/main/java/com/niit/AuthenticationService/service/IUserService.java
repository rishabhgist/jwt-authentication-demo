package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User save(User user);

    User findByUsernameAndPassword(String username, String password);
}
