package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.FormNilai;
import com.example.manajemen_talenta.model.entity.Pegawai;
import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.repository.FormNilaiRepository;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Penilaian360 {

    private final PegawaiRepository pegawaiRepository;
    private final FormNilaiRepository formNilaiRepository;

    public void menilai360(User user, String pegawaiId, Map<String, String> request) {

        String pegawaiYangDinilai = request.get("dinilai");
        Long penilaianId  = Long.parseLong(request.get("penilaian360"));
        Integer nilai =  Integer.parseInt(request.get("nilai"));

        if (user.getRole().equals(Role.PEGAWAI)) {
            Optional<Pegawai> pegawaiObject = pegawaiRepository.findByUser(user.getId());
            if (pegawaiObject.isPresent()) {
                Pegawai pegawai = pegawaiObject.get();
                List<String> targetDinilai = pegawai.getListDinilai();
                targetDinilai.remove(pegawaiId);
                pegawai.setListDinilai(targetDinilai);
                pegawaiRepository.save(pegawai);
            }
            Optional<Pegawai> pegawaiDinilaiObject = pegawaiRepository.findByUser(user.getId());
            if (pegawaiDinilaiObject.isPresent()) {
                Pegawai pegawai = pegawaiDinilaiObject.get();
                Optional<FormNilai> formNilaiObject =  formNilaiRepository.findByPegawaiIdAndPenilaian360(pegawai.getId(), penilaianId);
                if (formNilaiObject.isPresent()) {
                    FormNilai formNilai = formNilaiObject.get();
                    formNilai.setRataRata((formNilai.getRataRata() + nilai)/2);
                    formNilai.setBanyakPenilai(formNilai.getBanyakPenilai() - 1);
                    formNilaiRepository.save(formNilai);
                }
            }
        }
    }
}
