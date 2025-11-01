package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.Pegawai;
import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.model.request.AssignRequest;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PegawaiRepository pegawaiRepository;
    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String role = request.get("role");
        if (role.equals(Role.PEGAWAI)) {
            pegawaiRepository.save(
                    Pegawai.builder()
                            .nama(username)
                            .build()
            );
        }

        // contoh: ROLE_ADMIN_HR, ROLE_PEGAWAI
        return userService.createUser(username, password, role);
    }

    @PostMapping("/assign")
    public Pegawai assign(@RequestBody AssignRequest request, String idPegawai) {
        Pegawai pegawai = pegawaiRepository.findById(Long.parseLong(idPegawai)).get();
        pegawai.setPeer(request.getPeer());
        pegawai.setBawahan(request.getBawahan());
        pegawai.setAtasanId(request.getAtasan());
        return pegawaiRepository.save(pegawai);

    }
}
