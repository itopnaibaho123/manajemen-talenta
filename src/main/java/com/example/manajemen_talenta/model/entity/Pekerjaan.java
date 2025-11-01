package com.example.manajemen_talenta.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pekerjaan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pekerjaan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pekerjaan;
    private int level;
    private String bobot;
    private String kriteria;

}
