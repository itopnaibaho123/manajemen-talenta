package com.example.manajemen_talenta.model.entity;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Document(collection = "pegawai")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user;
    private String nama;

    // atasan berbasis id pegawai (String ID eksternal / kode pegawai)
    private String atasanId;
    private List<String> bawahan;
    private List<Long> listDinilai;
    private List<String> peer;


}
