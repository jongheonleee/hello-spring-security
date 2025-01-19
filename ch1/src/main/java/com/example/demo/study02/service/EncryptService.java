package com.example.demo.study02.service;

import org.springframework.stereotype.Service;

@Service
public class EncryptService {

    public String encrypt(String password) {
        return "encrypted_" + password;
    }
}
