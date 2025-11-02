package com.example.manajemen_talenta.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "person_job")
public class PersonJobMatch {

    @Id
    private String id;
    private List<Pekerjaan> pekerjaan;
    private String pegawai;
}
