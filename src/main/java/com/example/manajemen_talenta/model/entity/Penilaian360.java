package com.example.manajemen_talenta.model.entity;



import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "penilaian_360")
public class Penilaian360 {

    @Id
    private String id;

    private String namaPeriode;
    private String tanggalMulai;   // bisa diubah ke LocalDate jika mau
    private String tanggalSelesai;
    private String status;

    private String alamat;


    private List<String> tim;

    private List<Pertanyaan> pertanyaanList;

}
