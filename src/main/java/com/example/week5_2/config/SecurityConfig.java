package com.example.week5_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Tắt CSRF cho dễ test form & Postman (chỉ nên làm trong bài tập)
                .csrf(csrf -> csrf.disable())

                // Phân quyền cho các request
                .authorizeHttpRequests(auth -> auth
                        // Cho phép truy cập không cần login vào static resources
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                        // Cho phép truy cập không cần login vào tất cả trang tour & booking
                        .requestMatchers("/tours/**").permitAll()
                        // Nếu còn trang nào public khác thì thêm vào đây
                        // .requestMatchers("/", "/home", "/register").permitAll()
                        // Các request còn lại thì cần đăng nhập
                        .anyRequest().authenticated()
                )

                // Vẫn giữ form login mặc định (nếu sau này bạn cần đăng nhập)
                .formLogin(form -> form
                        .loginPage("/login") // nếu bạn có custom login page, còn chưa thì bỏ dòng này
                        .permitAll()
                )

                // Cho phép logout
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
