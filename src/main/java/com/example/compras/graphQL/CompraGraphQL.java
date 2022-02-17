package com.example.compras.graphQL;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Compra;
import com.example.compras.graphQL.dto.CompraRelatorio;
import com.example.compras.graphQL.input.CompraInput;
import com.example.compras.domain.service.ClienteService;
import com.example.compras.domain.service.CompraService;
import com.example.compras.domain.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final CompraService compraService;

    private final ClienteService clienteService;

    private final ProdutoService produtoService;
    @Autowired
    public CompraGraphQL(CompraService compraService, ClienteService clienteService,
                         ProdutoService produtoService) {
        this.compraService = compraService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public Compra salvarCompra(CompraInput compraInput) {
        ModelMapper modelMapper = new ModelMapper();
        Compra compra = Compra.builder()
                .cliente(this.clienteService.findById(compraInput.getCliente()))
                .produto(this.produtoService.findById(compraInput.getProduto()))
                .id(compraInput.getId())
                .quantidade(compraInput.getQuantidade())
                .status(compraInput.getStatus())
                .data(LocalDate.now())
                .build();
        return this.compraService.save(compra);
    }

    public Boolean deletarCompra(Long id) {
        return this.compraService.delete(id);
    }

    public Compra compraById(Long id) {
        return this.compraService.findById(id);
    }

    public Page<Compra> compras(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.compraService.findAll(pageable);
    }

    public List<CompraRelatorio> compraRelatorio(Long id) {
        return this.compraService.compraRelatorio(id);
    }

}
