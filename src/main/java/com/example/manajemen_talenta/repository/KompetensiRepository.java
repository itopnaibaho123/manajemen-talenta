package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.Kompetensi;
import com.example.manajemen_talenta.model.entity.Penilaian360;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KompetensiRepository extends MongoRepository<Kompetensi, String> {

}
