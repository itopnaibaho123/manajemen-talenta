package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.service.Penilaian360Service;
import com.example.manajemen_talenta.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/pegawai")
@RequiredArgsConstructor
public class PegawaiController {

    private final UserService userService;
    private final Penilaian360Service penilaian360Service;

    @PostMapping("/penilaian360/{idPegawai}")
    public void menilai(@RequestBody Map<String, String> request,
                         @PathVariable String idPegawai, Authentication authentication) {
    
        Principal principal = (Principal) authentication.getPrincipal();
                        
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getRole() != Role.PEGAWAI) {
            throw new RuntimeException("User is not a pegawai");
        }

        penilaian360Service.menilai360(user, idPegawai, request);

    }

    @PostMapping("/riwayat")
    public void riwayat (@RequestBody Map<String, String> request, Authentication authentication) {
        Principal principal = (Principal) authentication.getPrincipal();
                        
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getRole() != Role.PEGAWAI) {
            throw new RuntimeException("User is not a pegawai");
        }

        penilaian360Service.riwayat(user, request);
    }
}
