package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.Penilaian360;
import com.example.manajemen_talenta.model.entity.PersonJobMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonJobMatchRepository extends MongoRepository<PersonJobMatch, Long> {
    Optional<PersonJobMatch> findByPegawai(String pegawai);
}

