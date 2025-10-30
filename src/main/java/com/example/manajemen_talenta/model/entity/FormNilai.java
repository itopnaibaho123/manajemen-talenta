package com.example.manajemen_talenta.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "form_nilai")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormNilai {


    private Long pegawaiId;

    private Long penilaian360;

    private Integer rataRata;

    private Integer banyakDataMasuk;
}
