package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String role = request.get("role"); // contoh: ROLE_ADMIN_HR, ROLE_PEGAWAI
        return userService.createUser(username, password, role);
    }
}
