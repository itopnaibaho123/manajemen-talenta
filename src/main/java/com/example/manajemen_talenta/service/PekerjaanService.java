package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.JobPersonMatch;
import com.example.manajemen_talenta.model.entity.Pegawai;
import com.example.manajemen_talenta.model.entity.Pekerjaan;
import com.example.manajemen_talenta.repository.JobPersonMatchRepository;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.repository.PekerjaanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PekerjaanService {

    private final PekerjaanRepository pekerjaanRepository;
    private final PegawaiRepository pegawaiRepository;
    private final JobPersonMatchRepository jobPersonMatchRepository;


    public Pekerjaan createPekerjaan(Pekerjaan pekerjaan) {
        Pekerjaan pekerjaan1 =  pekerjaanRepository.save(pekerjaan);
        return pekerjaan1;
    }

    public JobPersonMatch createJobPersonMatch(Long idPegawai) {
        Pegawai pegawai = new Pegawai();
        Optional<Pegawai> pegawaiOptional = pegawaiRepository.findById(idPegawai);
        if (pegawaiOptional.isPresent()) {
            pegawai = pegawaiOptional.get();
        }

        List<Pekerjaan> pekerjaanList = pekerjaanRepository.findAll();

        if(pekerjaanList.size() > 3) {

        }

        Pekerjaan pekerjaan1 =  pekerjaanRepository.save(pekerjaan);
        return pekerjaan1;
    }
}
