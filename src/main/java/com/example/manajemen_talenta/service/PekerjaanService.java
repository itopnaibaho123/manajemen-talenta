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

    public Pekerjaan createPekerjaan(Pekerjaan pekerjaan) {
        return pekerjaanRepository.save(pekerjaan);
    }

    public List<Pekerjaan> getALlPekerjaan() {
        return pekerjaanRepository.findAll();
    }
}
