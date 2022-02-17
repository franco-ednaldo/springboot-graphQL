package com.example.compras.domain.service;

import com.example.compras.domain.Cliente;
import com.example.compras.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Transactional
    public Boolean delete(Long id) {
        try {
            this.clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Cliente findById(Long id) {
        return this.clienteRepository.findById(id)
                .orElse(Cliente.builder().build());
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

}
