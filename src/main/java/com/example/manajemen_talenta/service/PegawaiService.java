package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.*;
import com.example.manajemen_talenta.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PegawaiService {
    private final PegawaiRepository pegawaiRepository;
    private final PekerjaanRepository pekerjaanRepository;
    private final PersonJobMatchRepository personJobMatchRepository;
    private final JobPersonMatchRepository jobPersonMatchRepository;
    private final KompetensiRepository kompetensiRepository;

    private List<Pegawai> getAllPegawai() {
        return pegawaiRepository.findAll();
    }

    public Pegawai getPegawai(String id) {
        return pegawaiRepository.findByUser(id).orElse(null);
    }


    public PersonJobMatch getPegawaiJobMatch(User user) {
        Pegawai pegawai = new Pegawai();
        PersonJobMatch personJobMatch = new PersonJobMatch();



        Optional<Pegawai> pegawaiObject = pegawaiRepository.findByUser(user.getId());
        if(pegawaiObject.isPresent()) {
            pegawai = pegawaiObject.get();
        }
        Optional<PersonJobMatch> personJobMatchOptional = personJobMatchRepository.findByPegawai(pegawai.getId());


        if (personJobMatchOptional.isPresent()) {
            personJobMatch = personJobMatchOptional.get();
            return personJobMatch;
        }

        List<Pekerjaan> listPerkerjaaan = pekerjaanRepository.findAll();
        personJobMatch.setPegawai(String.valueOf(pegawai.getId()));
        if(listPerkerjaaan.size() > 5 ) {
            List<Pekerjaan> listPekerjaanMasukan = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int index = random.nextInt(listPerkerjaaan.size());
                listPekerjaanMasukan.add(listPerkerjaaan.get(index));
                listPerkerjaaan.remove(index);
            }
            personJobMatch.setPekerjaan(listPekerjaanMasukan);
        } else {

            personJobMatch.setPekerjaan(listPerkerjaaan);
        }

        List<Kompetensi> listKompetensi = kompetensiRepository.findAll();

        if(listKompetensi.size() > 3 ) {
            List<Kompetensi> listKompetensiMasukan = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Random random = new Random();
                int index = random.nextInt(listKompetensi.size());
                listKompetensi.remove(index);

            }
            pegawai.setKompetensi(listKompetensiMasukan);
        } else  {
            pegawai.setKompetensi(listKompetensi);
        }
        pegawaiRepository.save(pegawai);
        return personJobMatchRepository.save(personJobMatch);
    }

    public JobPersonMatch getJobPegawaiMatch(String pekerjaan) {

        JobPersonMatch jobPersonMatch = new JobPersonMatch();

        Optional<JobPersonMatch> jobPersonMatchOptional = jobPersonMatchRepository.findByPekerjaan(pekerjaan);
        if (jobPersonMatchOptional.isPresent()) {
            return jobPersonMatchOptional.get();
        }

        List<Pegawai> listPegawai = getAllPegawai();
        jobPersonMatch.setPekerjaan(pekerjaan);
        if(listPegawai.size() > 5 ) {
            List<Pegawai> listPegawaiMasukan = new ArrayList<>();
            for (int i = 0; i < listPegawai.size(); i++) {
                Random random = new Random();
                int index = random.nextInt(listPegawai.size());
                listPegawaiMasukan.add(listPegawai.get(index));
                listPegawai.remove(index);
            }
            jobPersonMatch.setPegawai(listPegawaiMasukan);
        } else {
            jobPersonMatch.setPegawai(listPegawai);
        }
        return jobPersonMatchRepository.save(jobPersonMatch);
    }

}
