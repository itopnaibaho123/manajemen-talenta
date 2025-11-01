package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.FormNilai;
import com.example.manajemen_talenta.model.entity.Pegawai;
import com.example.manajemen_talenta.model.entity.Penilaian360;
import com.example.manajemen_talenta.model.response.PrediksiResignSummary;
import com.example.manajemen_talenta.repository.FormNilaiRepository;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.repository.Penilaian360Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResignService {

    private final FormNilaiRepository formNilaiRepository;
    private final Penilaian360Repository penilaian360Repository;
    private final PegawaiRepository pegawaiRepository;

    private Penilaian360 getCurrent360() {
        return penilaian360Repository.findAll().getLast();
    }

    public List<PrediksiResignSummary> getPrediksiResignSummary() {
        List<PrediksiResignSummary> prediksiResignSummary = new ArrayList<>();

        List<FormNilai> formNilai = formNilaiRepository.findAllByPenilaian360(getCurrent360().getId());
        for (FormNilai formNilai1 : formNilai) {
            Pegawai pegawai = new Pegawai();
            Optional<Pegawai> pegawaiObject = pegawaiRepository.findById(formNilai1.getPegawaiId());
            if (pegawaiObject.isPresent()) {
                pegawai = pegawaiObject.get();
            }
            prediksiResignSummary.add(new PrediksiResignSummary(pegawai.getNama(), pegawai.getId(), formNilai1.getRataRata(), getDurasi(formNilai1.getRataRata())));
        }
        return prediksiResignSummary;
    }

    private String getDurasi(Integer rataRata) {

        if (rataRata >= 0 && rataRata < 5) {
            return "Akan Keluar dalam waktu 1 Bulan";
        } else if (rataRata >= 5 && rataRata < 15) {
            return  "Akan Resign dalam waktu 3 Bulan";
        } else if (rataRata >= 15 && rataRata < 25) {
            return  "Akan Resign dalam waktu 5 Bulan";
        } else if (rataRata >= 25 && rataRata < 30) {
            return "Akan Resign dalam waktu 8 Bulan";
        } else if (rataRata >= 30 && rataRata < 50) {
            return "Akan Resign dalam waktu 1 tahun";
        } else {
            return "Akan Resign dalam waktu 2 tahun";
        }
    }
}
