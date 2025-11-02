package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.*;
import com.example.manajemen_talenta.repository.FormNilaiRepository;
import com.example.manajemen_talenta.repository.KompetensiRepository;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.repository.Penilaian360Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KompetensiService {
    private final KompetensiRepository kompetensiRepository;
    private final PegawaiRepository pegawaiRepository;


    public List<Kompetensi> getAllKompetensiPegawai(String id){


        Pegawai pegawai = new Pegawai();
        Optional<Pegawai> pegawaiObject = pegawaiRepository.findByUser(id);

        if (pegawaiObject.isPresent()) {
            pegawai = pegawaiObject.get();
        }
        return pegawai.getKompetensi();
    }

    public Pegawai updateKompetensiPegawai(List<Kompetensi> kompetensi, String idPegawai){

        Pegawai pegawai = new Pegawai();
        Optional<Pegawai> pegawaiObject = pegawaiRepository.findById(idPegawai);
        if (pegawaiObject.isPresent()) {
            pegawai = pegawaiObject.get();
            pegawai.setKompetensi(kompetensi);
        }

        return pegawaiRepository.save(pegawai);
    }

    public Kompetensi createKompetensi(Kompetensi kompetensi) {
        return kompetensiRepository.save(kompetensi);
    }

    public List<Pegawai> getAllPegawai(){
        return pegawaiRepository.findAll();
    }
}
