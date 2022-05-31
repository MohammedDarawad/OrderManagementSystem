package com.webservices.oms.ordermanagementsystem.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasscodeEncoderGenarator {

    public class PasswordEncoderGenerator {
        public void main(String[] args) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode("admin"));
        }
    }
}
