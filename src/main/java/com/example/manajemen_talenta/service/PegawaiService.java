package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.Pegawai;
import com.example.manajemen_talenta.model.entity.Pekerjaan;
import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.entity.PersonJobMatch;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.repository.PekerjaanRepository;
import com.example.manajemen_talenta.repository.PersonJobMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PegawaiService {
    private final PegawaiRepository pegawaiRepository;
    private final PekerjaanRepository pekerjaanRepository;
    private final PersonJobMatchRepository personJobMatchRepository;

    public List<Pegawai> getAllPegawai() {
        return pegawaiRepository.findAll();
    }

}
