package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.FormNilai;
import com.example.manajemen_talenta.model.entity.Penilaian360;
import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.model.response.FormPenilaianSummary;
import com.example.manajemen_talenta.service.Penilaian360Service;
import com.example.manajemen_talenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/HRPenilaian")
@RequiredArgsConstructor
public class HrPenilaianController {
    private final Penilaian360Service penilaian360Service;
    private final UserService userService;


    @PostMapping("/penilaian360")
    public Penilaian360 membuatPenilaian(@RequestBody Penilaian360 request, Authentication authentication) {

        Principal principal = (Principal) authentication.getPrincipal();

        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getRole() != Role.PEGAWAI) {
            throw new RuntimeException("User is not a HRPenilaian");
        }

        return penilaian360Service.createPenilaian360(user, request);

    }

    @GetMapping("/penilaian360")
    public List<Penilaian360> melihatSeluruhPenilaian360() {
        return penilaian360Service.getAllPenilaian360();
    }

    @GetMapping("/penilaian360/pegawai/{idPegawai}")
    public FormNilai melihatPenilaian360Pegawai(@PathVariable String idPegawai) {
        return penilaian360Service.melihat360(idPegawai, String.valueOf(penilaian360Service.getCurrent360().getId()));
    }

    @GetMapping("/penilaian360/{idPenilaian360}")
    public List<FormPenilaianSummary> melihatSeluruhPenilaian360Periode(@PathVariable String idPenilaian360) {
        return penilaian360Service.getListFormPenilaian360(idPenilaian360);
    }

    @PutMapping("/penilaian360/{idPenilaian360}")
    public Penilaian360 menyelesaikanPenilaian360Periode(@PathVariable String idPenilaian360) {
        return penilaian360Service.setSelesaiPenilaian360(idPenilaian360);
    }

}
