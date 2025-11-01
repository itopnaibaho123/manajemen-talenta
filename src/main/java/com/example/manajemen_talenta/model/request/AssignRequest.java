package com.example.manajemen_talenta.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignRequest {
    private String atasan;
    private List<String> bawahan;
    private List<String> peer;
}
