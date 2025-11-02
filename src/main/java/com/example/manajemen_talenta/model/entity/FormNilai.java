package com.example.manajemen_talenta.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "form_nilai")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormNilai {

    @Id
    private String id;

    private String pegawaiId;

    private String penilaian360;

    private Integer rataRata;

    private Integer banyakDataMasuk;
}
