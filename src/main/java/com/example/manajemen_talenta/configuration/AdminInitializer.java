package com.example.manajemen_talenta.configuration;

import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.repository.UserRepository;
import com.example.manajemen_talenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class AdminInitializer {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initAdmin(UserRepository userRepository) {
        return args -> {
            String username = "admin";
            String password = "admin123";
            if (userRepository.findByUsername(username).isEmpty()) {
                User admin = new User();
                admin.setUsername(username);
                admin.setPassword(passwordEncoder.encode(password));
                admin.setRole(Role.ADMIN);
                userRepository.save(admin);
                System.out.println("✅ Default admin created: username=admin, password=admin123");
            }
        };
    }
}
