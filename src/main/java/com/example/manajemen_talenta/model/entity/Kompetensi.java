package com.example.manajemen_talenta.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;


@Document(collection = "kompetensi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kompetensi {

    @Id
    private String id;
    private String nama;
    private List<String> pelatihan;
    private Integer bobot;
}
