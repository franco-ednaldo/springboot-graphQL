package com.example.compras.domain.service;

import com.example.compras.domain.Produto;
import com.example.compras.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public Boolean delete(Long id) {
        try {
            this.produtoRepository.deleteById(id);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    public Produto findById(Long id) {
        return this.produtoRepository.findById(id).orElse(Produto.builder().build());
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }
}
