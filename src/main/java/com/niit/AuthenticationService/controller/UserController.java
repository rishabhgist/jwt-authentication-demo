package com.niit.AuthenticationService.controller;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.UserNotFoundException;
import com.niit.AuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<?> findUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getByUsernameAndPassword(user), HttpStatus.OK);
    }
}
