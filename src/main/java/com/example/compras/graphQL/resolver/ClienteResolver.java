package com.example.compras.graphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import com.example.compras.domain.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {
    private final CompraRepository repository;

    @Autowired
    public ClienteResolver(CompraRepository repository) {
        this.repository = repository;
    }

    public List<Compra> compras(Cliente cliente) {
        return this.repository.findAllByCliente(cliente);
    }
}
