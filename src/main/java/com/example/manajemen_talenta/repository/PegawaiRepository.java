package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.Pegawai;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PegawaiRepository extends MongoRepository<Pegawai, String> {
    Optional<Pegawai> findByUser(String user);
}
