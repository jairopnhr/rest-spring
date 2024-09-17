package com.example.spring_rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_rest.entity.Produto;
import com.example.spring_rest.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/produto")
public class ProdutoController  {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listAll() {
        List<Produto> produtos = produtoService.listAll() ;
        return ResponseEntity.ok().body(produtos);
    }
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto newProduto = this.produtoService.save(produto);
        
        return new ResponseEntity<>( newProduto,HttpStatus.CREATED);
    }

    @GetMapping( "/{id}") 
    public ResponseEntity<Produto> procurarProdutoPeloId(@PathVariable("id") Long id) {
        Produto produtos = produtoService.findByID(id) ;
        return ResponseEntity.ok().body(produtos);
    }
    
}
