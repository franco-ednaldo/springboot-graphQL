package com.example.compras.graphQL.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompraRelatorio {
    private String cliente;

    private String produto;

    private Integer quantidade;

    private Double valor;
}
