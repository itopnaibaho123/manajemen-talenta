package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.JobPersonMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPersonMatchRepository extends MongoRepository<JobPersonMatch, String> {
    Optional<JobPersonMatch> findByPekerjaan(String pekerjaan);
}
