package com.example.manajemen_talenta.controller;

import com.example.manajemen_talenta.model.entity.*;
import com.example.manajemen_talenta.model.response.PrediksiResignSummary;
import com.example.manajemen_talenta.service.KompetensiService;
import com.example.manajemen_talenta.service.PegawaiService;
import com.example.manajemen_talenta.service.PekerjaanService;
import com.example.manajemen_talenta.service.ResignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HRPengembangan")
@RequiredArgsConstructor
public class HrPengembanganController {

    private final PekerjaanService pekerjaanService;
    private final PegawaiService pegawaiService;
    private final KompetensiService kompetensiService;
    private final ResignService resignService;

    @PostMapping("/pekerjaan")
    public Pekerjaan membuatPekerjaan(@RequestBody Pekerjaan pekerjaan) {
        return pekerjaanService.createPekerjaan(pekerjaan);
    }

    @GetMapping("/pekerjaan")
    public List<Pekerjaan> getAllPekerjaan() {
        return pekerjaanService.getALlPekerjaan();
    }

    @GetMapping("/job-person-match/{idPekerjaan}")
    public JobPersonMatch getJobPersonmatch(@PathVariable String idPekerjaan) {
        return pegawaiService.getJobPegawaiMatch(idPekerjaan);
    }

    @PostMapping("/kompetensi")
    public Kompetensi createKompetensi(@RequestBody Kompetensi kompetensi) {
        return kompetensiService.createKompetensi(kompetensi);
    }

    @GetMapping("/kompetensi/pegawai/{idPegawai}")
    public List<Kompetensi> createKompetensi(@PathVariable String idPegawai) {
        return kompetensiService.getAllKompetensiPegawai(idPegawai);
    }

    @GetMapping("/kompetensi/pegawai")
    public List<Pegawai> getAllPegawai() {
        return kompetensiService.getAllPegawai();
    }

    @PutMapping("/kompetensi/pegawai/{idPegawai}")
    public Pegawai updateKompetensi(@RequestBody List<Kompetensi> kompetensi, @PathVariable String idPegawai) {
        return kompetensiService.updateKompetensiPegawai(kompetensi, idPegawai);
    }

    @PutMapping("/resign/{idPegawai}")
    public PrediksiResignSummary updateKompetensi( @PathVariable String idPegawai) {
        return resignService.prediksiResignSummary(idPegawai);
    }
}
