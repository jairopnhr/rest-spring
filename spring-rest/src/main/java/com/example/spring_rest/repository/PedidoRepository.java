package com.example.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_rest.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    
}
