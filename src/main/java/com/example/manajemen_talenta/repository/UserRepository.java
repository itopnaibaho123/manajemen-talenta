package com.example.manajemen_talenta.repository;

import com.example.manajemen_talenta.model.entity.User;
import com.example.manajemen_talenta.model.enums.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
