package com.example.manajemen_talenta.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pekerjaan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pekerjaan {
    @Id
    private String id;
    private String pekerjaan;
    private int level;
    private String bobot;
    private String kriteria;

}
