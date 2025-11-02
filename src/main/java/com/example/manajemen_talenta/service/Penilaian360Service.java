package com.example.manajemen_talenta.service;

import com.example.manajemen_talenta.model.entity.*;
import com.example.manajemen_talenta.model.enums.Role;
import com.example.manajemen_talenta.model.response.FormPenilaianSummary;
import com.example.manajemen_talenta.repository.FormNilaiRepository;
import com.example.manajemen_talenta.repository.KompetensiRepository;
import com.example.manajemen_talenta.repository.PegawaiRepository;
import com.example.manajemen_talenta.repository.Penilaian360Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Penilaian360Service {

    private final PegawaiRepository pegawaiRepository;
    private final FormNilaiRepository formNilaiRepository;
    private final Penilaian360Repository penilaian360Repository;

    public void menilai360(User user, String pegawaiId, Map<String, String> request) {

        String pegawaiYangDinilai = request.get("dinilai");
        String penilaianId  = request.get("penilaian360");
        Integer nilai =  Integer.parseInt(request.get("nilai"));

        if (user.getRole().equals(Role.PEGAWAI)) {
            Optional<Pegawai> pegawaiObject = pegawaiRepository.findByUser(user.getId());
            if (pegawaiObject.isPresent()) {
                Pegawai pegawai = pegawaiObject.get();
                pegawai.getListDinilai().add(penilaianId);
                pegawaiRepository.save(pegawai);
            }
            Optional<Pegawai> pegawaiDinilaiObject = pegawaiRepository.findByUser(pegawaiYangDinilai);
            if (pegawaiDinilaiObject.isPresent()) {
                Pegawai pegawai = pegawaiDinilaiObject.get();
                Optional<FormNilai> formNilaiObject =  formNilaiRepository.findByPegawaiIdAndPenilaian360(pegawai.getId(), penilaianId);
                if (formNilaiObject.isPresent()) {
                    FormNilai formNilai = formNilaiObject.get();
                    formNilai.setRataRata((formNilai.getRataRata() + nilai) / formNilai.getBanyakDataMasuk() == 0 ? 1 : 2);
                    formNilai.setBanyakDataMasuk(formNilai.getBanyakDataMasuk() + 1);
                    formNilaiRepository.save(formNilai);
                }
            }
        }
    }

    public Penilaian360 getCurrent360() {
        return penilaian360Repository.findAll().getLast();
    }

    public FormNilai melihat360(String id, String penilaian360) {
        FormNilai formNilai = new FormNilai();
        Optional<Pegawai> pegawaiObject = pegawaiRepository.findByUser(id);
        if (pegawaiObject.isPresent()) {
            Pegawai pegawai = pegawaiObject.get();
            Optional<FormNilai> formNilaiObject =  formNilaiRepository.findByPegawaiIdAndPenilaian360(pegawai.getId(), penilaian360);
            if (formNilaiObject.isPresent()) {
                formNilai = formNilaiObject.get();
            }
        } return formNilai;
    }






    public Penilaian360 createPenilaian360(User user, Penilaian360 request) {
        Penilaian360 penilaian360 = new Penilaian360();
        penilaian360.setNamaPeriode(request.getNamaPeriode());
        penilaian360.setTanggalMulai(request.getTanggalMulai());
        penilaian360.setTanggalSelesai(request.getTanggalSelesai());
        penilaian360.setStatus(request.getStatus());
        penilaian360.setAlamat(request.getAlamat());
        penilaian360.setTim(request.getTim());
        penilaian360.setPertanyaanList(request.getPertanyaanList());
        emptyPenilaian();
        return penilaian360Repository.save(penilaian360);






    }

    private void emptyPenilaian() {
        List<Pegawai> listPegawai = pegawaiRepository.findAll();
        for (Pegawai pegawai : listPegawai) {
            pegawai.setListDinilai(new ArrayList<>());
            pegawaiRepository.save(pegawai);
        }
    }

    public Penilaian360 setSelesaiPenilaian360(String penilaian360Id) {
        Penilaian360 penilaian360 = new Penilaian360();
        Optional<Penilaian360> penilaian360Object = penilaian360Repository.findById(penilaian360Id);
        if (penilaian360Object.isPresent()) {
             penilaian360 = penilaian360Object.get();
        }
        penilaian360.setStatus("Selesai");
        return penilaian360Repository.save(penilaian360);
    }

    public List<FormPenilaianSummary> getListFormPenilaian360(String penilaian360Id) {
        List<FormPenilaianSummary> result = new ArrayList<>();
        List<FormNilai> forms = formNilaiRepository.findAllByPenilaian360(penilaian360Id);
        for (FormNilai f : forms) {
            pegawaiRepository.findById(f.getPegawaiId()).ifPresent(p ->
                    result.add(new FormPenilaianSummary(p.getNama(), f.getRataRata()))
            );
        }
        return result;
    }

    public List<Penilaian360> getAllPenilaian360() {
        return penilaian360Repository.findAll();
    }
}
