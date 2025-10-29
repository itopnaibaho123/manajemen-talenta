package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pegawai")
@RequiredArgsConstructor
public class PegawaiController {

    @PostMapping("/penilaian360/{idPegawai}")
    public void menilai(@RequestBody Map<String, String> request,
                         @PathVariable Long idPegawai, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

    }

    @PostMapping("/riwayat")
    public void menilai(@RequestBody Map<String, String> request, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

    }
}
