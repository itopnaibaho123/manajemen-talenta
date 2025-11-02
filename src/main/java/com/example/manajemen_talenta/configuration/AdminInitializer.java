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
            String usernameHrPengembangan = "hrPengembangan";
            String passwordHrPengembangan = "hrPengembangan123";
            if (userRepository.findByUsername(usernameHrPengembangan).isEmpty()) {
                User hrPengembangan = new User();
                hrPengembangan.setUsername(usernameHrPengembangan);
                hrPengembangan.setPassword(passwordEncoder.encode(passwordHrPengembangan));
                hrPengembangan.setRole(Role.HR_PENGEMBANGAN);
                userRepository.save(hrPengembangan);
                System.out.println("✅ Default admin created: username=hrPengembangan, password=hrPengembangan123");
            }

            String usernameHrPenilaian = "hrPenilaian";
            String passwordHrPenilaian = "hrPenilaian123";
            if (userRepository.findByUsername(usernameHrPenilaian).isEmpty()) {
                User hrPenilaian = new User();
                hrPenilaian.setUsername(usernameHrPenilaian);
                hrPenilaian.setPassword(passwordEncoder.encode(passwordHrPenilaian));
                hrPenilaian.setRole(Role.HR_PENILAIAN);
                userRepository.save(hrPenilaian);
                System.out.println("✅ Default admin created: username=hrPenilaian, password=hrPenilaian123");
            }

            String userManajemen = "manajemen";
            String passwordManajemen = "manajemen123";
            if (userRepository.findByUsername(userManajemen).isEmpty()) {
                User manajemen = new User();
                manajemen.setUsername(userManajemen);
                manajemen.setPassword(passwordEncoder.encode(passwordManajemen));
                manajemen.setRole(Role.MANAJEMEN);
                userRepository.save(manajemen);
                System.out.println("✅ Default admin created: username=manajemen, password=manajemen123");
            }
        };
    }
}
