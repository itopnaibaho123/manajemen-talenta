package com.example.manajemen_talenta.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormPenilaianSummary {
    private String nama;
    private int rataRata;
}
