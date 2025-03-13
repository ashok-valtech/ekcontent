package com.uae.dubai.ekconent.Service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

   public  boolean authenticationService(String userName,String password) {

   boolean isValidUserName =  userName.equals("ashokkumar");
   boolean isValidPassword =  password.equals("dummy");

   return isValidUserName && isValidPassword;

   }
    
}
