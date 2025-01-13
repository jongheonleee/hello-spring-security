package com.example.demo.config;

import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


// 인증 공급자 구현
// - AuthenticationProvider 인터페이스를 구현한 클래스
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // 사용자 정보 조회
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        // 인증 로직 구현(if 문 추가)
        if ("yeonuel".equals(username) && "password".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, List.of());
        }

        throw new RuntimeException("auth error");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
