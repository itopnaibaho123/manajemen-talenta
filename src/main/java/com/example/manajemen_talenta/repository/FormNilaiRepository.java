package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.FormNilai;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormNilaiRepository extends MongoRepository<FormNilai, String> {
    Optional<FormNilai> findByPegawaiIdAndPenilaian360(Long pegawaiId, Long penilaian360);
}
