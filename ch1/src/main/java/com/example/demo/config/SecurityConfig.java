package com.example.demo.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 접근 권한 부여 재정의
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll()) // 모든 요청에 대한 인증을 요구 x
                .httpBasic(withDefaults()); // HTTP Basic 인증 사용(Bas64)
        return httpSecurity.build();
    }


    // UserDetailsService 빈 등록(인메모리, 운영 과정에선 쓰면 안됨)
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        // 테스트 사용자 등록
        UserDetails yeonuel = User.builder()
                                  .username("yeonuel")
                                  .password("password")
                                  .build();
        inMemoryUserDetailsManager.createUser(yeonuel);

        return inMemoryUserDetailsManager;
    }

    // UserDetailsService를 빈으로 등록하면, 그에 따라 PasswordEncoder도 빈으로 등록해야 함
    // - 특정 구현체끼리 짝을 맺고 있음
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
