package com.niit.AuthenticationService.controller;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.UserNotFoundException;
import com.niit.AuthenticationService.service.JwtImp;
import com.niit.AuthenticationService.service.SecurityTokenGenerator;
import com.niit.AuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {
    private UserService userService;
    private SecurityTokenGenerator tokenGenerator;
    @Autowired
    public UserController(UserService userService, JwtImp tokenGenerator) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
    }
    @GetMapping("/api/v1/users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<?> findUser(@RequestBody User user) throws UserNotFoundException {
        try{
            userService.getByUsernameAndPassword(user);
            Map<String, String> secretkey = new HashMap<>();
            secretkey = tokenGenerator.generateToken(user);
            return new ResponseEntity<>(secretkey, HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception e){
            return new ResponseEntity<>("Network Error !!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
