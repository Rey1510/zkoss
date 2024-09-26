package com.fif.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {

    public static void main(String[] args){
        String encryptedPassword = passwordEncoder().encode("admin");
        System.out.println(encryptedPassword);

        String encryptedPassword2 = passwordEncoder().encode("user");
        System.out.println(encryptedPassword2);
    }


    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
