package com.example.manajemen_talenta.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormPenilaianSummary {
    
    private String namaPegawai;
    private Integer rataRata;
}