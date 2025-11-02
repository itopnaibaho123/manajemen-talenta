package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.Pekerjaan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PekerjaanRepository extends MongoRepository<Pekerjaan, String> {

}
