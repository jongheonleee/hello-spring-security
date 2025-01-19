package com.example.demo.study02.controller.request;


import com.example.demo.study02.annotation.CustomEncryption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequestBody {

    private String id;

    @CustomEncryption
    private String password;
}
