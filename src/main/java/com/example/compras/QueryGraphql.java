package com.example.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryGraphql implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQL";
    }

    public Cliente cliente() {
        return Cliente.builder()
                .nome("EDNALDO FRANCO")
                .email("ednaldofranco.dev@gmail.com")
                .build();
    }

    public List<Cliente> clientes() {
        return List.of(Cliente.builder()
                        .nome("EDNALDO FRANCO")
                        .email("ednaldofranco.dev@gmail.com")
                        .build(),
                Cliente.builder()
                        .nome("ISABELA FERNANDES DA SILVA PRADO FRANCO")
                        .email("isabelaprado@gmail.com")
                        .build(),
                Cliente.builder()
                        .nome("ARTHUR PRADO FRANCO")
                        .email("arthurprado.@gmail.com")
                        .build());
    }

}
