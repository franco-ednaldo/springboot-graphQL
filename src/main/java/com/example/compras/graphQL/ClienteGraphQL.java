package com.example.compras.graphQL;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Cliente;
import com.example.compras.graphQL.input.ClienteInput;
import com.example.compras.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ClienteService clienteService;

    @Autowired
    public ClienteGraphQL(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente salvarCliente(ClienteInput clienteInput) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteInput, Cliente.class);
        return this.clienteService.save(cliente);
    }

    public Boolean deletarCliente(Long id) {
        return this.clienteService.delete(id);
    }

    public Cliente clienteById(Long id) {
        return this.clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return this.clienteService.findAll();
    }

}
