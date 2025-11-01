package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.*;
import com.example.manajemen_talenta.repository.FormNilaiRepository;
import com.example.manajemen_talenta.repository.KompetensiRepository;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.repository.Penilaian360Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KompetensiService {
    private final KompetensiRepository kompetensiRepository;
    private final FormNilaiRepository formNilaiRepository;
    private final PegawaiRepository pegawaiRepository;
    private final Penilaian360Repository penilaian360Repository;


    private Penilaian360 getCurrent360() {
        return penilaian360Repository.findAll().getLast();
    }


    public List<Kompetensi> getAllKompetensiPegawai(User user, Long id){
        List<Kompetensi> listKompetensiUser = new ArrayList<>();
        Pegawai pegawai = null;
        FormNilai formNilai = null;
        Optional<Pegawai> pegawaiObject = pegawaiRepository.findByUser(id == null ? user.getId() : id);

        if (pegawaiObject.isPresent()) {
            pegawai = pegawaiObject.get();
        }
        Penilaian360 penilaian360 = getCurrent360();
        Optional<FormNilai> formNilaiObject =  formNilaiRepository.findByPegawaiIdAndPenilaian360(pegawai.getId(), penilaian360.getId());
        if (formNilaiObject.isPresent()) {
            formNilai = formNilaiObject.get();
        }

        for (Kompetensi kompetensi : kompetensiRepository.findAll()) {
            if (kompetensi.getBobot() > formNilai.getRataRata()) {
                listKompetensiUser.add(kompetensi);
            }
        }
        return listKompetensiUser;
    }

    public Kompetensi createKompetensi(Kompetensi kompetensi) {
        return kompetensiRepository.save(kompetensi);
    }
}
