package com.example.compras.graphQL.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompraInput {
    private Long id;

    private Integer quantidade;

    private String status;

    private Long cliente;

    private Long produto;
}
