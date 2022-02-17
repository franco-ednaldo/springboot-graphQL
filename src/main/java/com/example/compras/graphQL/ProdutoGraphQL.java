package com.example.compras.graphQL;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Produto;
import com.example.compras.graphQL.input.ProdutoInput;
import com.example.compras.domain.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {
    private ProdutoService produtoService;

    @Autowired
    public ProdutoGraphQL(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public Produto salvarProduto(ProdutoInput produtoInput) {
        var modelMapper = new ModelMapper();
        var produto = modelMapper.map(produtoInput, Produto.class);
        return this.produtoService.save(produto);
    }

    public Boolean deleteProduto(Long id) {
        return this.produtoService.delete(id);
    }

    public Produto produtoById(Long id) {
        return this.produtoService.findById(id);
    }

    public List<Produto> produtos() {
        return  this.produtoService.findAll();
    }
}
