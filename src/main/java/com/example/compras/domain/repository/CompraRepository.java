package com.example.compras.domain.repository;

import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import com.example.compras.graphQL.dto.CompraRelatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query(value = "select c FROM Compra c join fetch c.cliente cli  join fetch c.produto p where c.cliente= :cliente ")
    List<Compra> findAllByCliente(@Param("cliente") Cliente cliente);

    @Query("select new com.example.compras.graphQL.dto.CompraRelatorio(c.cliente.nome, c.produto.nome, c.quantidade, c.produto.valor)" +
            " from Compra c where c.id=:id")
    List<CompraRelatorio> compraFindById(@Param("id") Long id);
}
