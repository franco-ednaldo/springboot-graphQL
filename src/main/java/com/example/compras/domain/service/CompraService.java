package com.example.compras.domain.service;

import com.example.compras.domain.Compra;
import com.example.compras.domain.repository.CompraRepository;
import com.example.compras.graphQL.dto.CompraRelatorio;
import com.example.compras.graphQL.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {
    private CompraRepository compraRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra findById(Long id) {
        return this.compraRepository.findById(id).orElse(Compra.builder().build());
    }

    public Page<Compra> findAll(Pageable pageable) {
        return this.compraRepository.findAll(pageable);
    }

    @Transactional
    public Compra save(Compra compra) {
        return this.compraRepository.save(compra);
    }

    @Transactional
    public Boolean delete(Long id) {
        try {
            this.compraRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CompraRelatorio> compraRelatorio(Long id) {
        //throw new DomainException("Nenhum registro encontrado com id informado!");
        return this.compraRepository.compraFindById(id);
    }
}
