package com.example.demo.study02.aspect;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.demo.study02.controller.request.HelloRequestBody;
import com.example.demo.study02.service.EncryptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PasswordEncryptionAspectTest {

    PasswordEncryptionAspect aspect;

    @Mock
    EncryptService encryptService;

    @BeforeEach
    void setUp() {
        aspect = new PasswordEncryptionAspect(encryptService);
    }

    @Test
    void test() {
        HelloRequestBody request = new HelloRequestBody("id", "password");
        when(encryptService.encrypt(any())).thenReturn("encrypted");

        aspect.fieldEncryption(request);

        assertEquals("encrypted", request.getPassword());
    }
}