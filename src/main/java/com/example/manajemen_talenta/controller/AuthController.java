package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.repository.UserRepository;
import com.example.manajemen_talenta.service.UserService;
import com.example.manajemen_talenta.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.get("username"), request.get("password"))
            );
            UserDetails user = userService.loadUserByUsername(request.get("username"));
            String token = jwtUtil.generateToken(user);
            return Map.of("token", token, "role", user.getAuthorities().iterator().next().getAuthority());
        } catch (AuthenticationException e) {
            return Map.of("error", "Username atau password salah");
        }
    }
}
