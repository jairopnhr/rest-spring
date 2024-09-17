package com.example.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_rest.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}
