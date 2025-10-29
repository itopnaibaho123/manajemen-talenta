package com.example.manajemen_talenta.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "kompetensi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kompetensi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String deskripsi;
    private Integer bobot;
}
