package com.example.manajemen_talenta.model.entity;
import lombok.AllArgsConstructor;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;


@Document(collection = "pegawai")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pegawai {

    @Id
    private String id;
    private String user;
    private String nama;
    private String atasanId;
    private List<String> bawahan;
    private List<String> listDinilai;
    private List<Kompetensi> kompetensi;
    private List<String> peer;


}
