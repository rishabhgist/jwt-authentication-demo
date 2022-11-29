package com.niit.AuthenticationService.service;
import com.niit.AuthenticationService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
        Map<String,String> generateToken(User user);
}
