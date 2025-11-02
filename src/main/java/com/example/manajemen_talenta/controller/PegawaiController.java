package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.FormNilai;
import com.example.manajemen_talenta.model.entity.Pegawai;
import com.example.manajemen_talenta.model.entity.PersonJobMatch;
import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.service.PegawaiService;
import com.example.manajemen_talenta.service.Penilaian360Service;
import com.example.manajemen_talenta.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pegawai")
@RequiredArgsConstructor
public class PegawaiController {

    private final UserService userService;
    private final Penilaian360Service penilaian360Service;
    private final PegawaiService pegawaiService;

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

    @GetMapping("/penilaian360/{idPegawai}")
    public FormNilai melihatPenilaian360Pegawai(@PathVariable String idPegawai) {
        return penilaian360Service.melihat360(idPegawai, String.valueOf(penilaian360Service.getCurrent360().getId()));
    }

    @GetMapping("/person-job-match")
    public PersonJobMatch melihatPenilaian360Pegawai(Authentication authentication) {
        Principal principal = (Principal) authentication.getPrincipal();

        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        return pegawaiService.getPegawaiJobMatch(user);
    }

    @GetMapping("/me")
    public Pegawai getMe(Authentication authentication) {
        Principal principal = (Principal) authentication.getPrincipal();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        return pegawaiService.getPegawai(user.getId());
    }
}
