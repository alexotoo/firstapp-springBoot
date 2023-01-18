package com.alexotoodev.firstapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
       boolean isValidUser = username.equalsIgnoreCase("tester");
       boolean isValidPassword = password.equalsIgnoreCase("12345");

        
        return  isValidUser && isValidPassword; }
    
}
