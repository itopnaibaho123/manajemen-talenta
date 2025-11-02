package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.FormNilai;
import com.example.manajemen_talenta.model.entity.Penilaian360;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Penilaian360Repository extends MongoRepository<Penilaian360, String> {

}
