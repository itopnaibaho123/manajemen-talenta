package com.example.manajemen_talenta.model.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pertanyaan {

    private String question;
    private String kategori;
    private Integer bobot;
}
