package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.JobPersonMatch;
import com.example.manajemen_talenta.model.entity.PersonJobMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPersonMatchRepository extends MongoRepository<JobPersonMatch, Long> {
    Optional<PersonJobMatch> findByPegawai(String pegawai);
}
