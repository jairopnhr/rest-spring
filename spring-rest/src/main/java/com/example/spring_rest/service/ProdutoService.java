package com.example.spring_rest.service;

import com.example.spring_rest.entity.Produto;
import com.example.spring_rest.error.NotFoundProdutoException;
import com.example.spring_rest.error.ProdutoNullException;
import com.example.spring_rest.error.ProdutoPriceException;
import com.example.spring_rest.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Busca um produto pelo ID.
     * 
     * @param id ID do produto a ser buscado.
     * @return Produto encontrado ou exceção se não for encontrado.
     * @throws NotFoundProdutoException se o produto não for encontrado.
     */
    public Produto findByID(Long id) {
        // Verifica se o produto existe antes de buscar
        return produtoRepository.findById(id)
            .orElseThrow(() -> new NotFoundProdutoException("Produto de Id: " + id + " não encontrado"));
    }
    /**
     * Salvar produto 
     * @param Produto 
     * @return retornar produto salvo
     * @throws ExistsProdutoException 
     */
    public Produto save(Produto produto)
    {
        validarProduto(produto);
         return produtoRepository.save(produto);
        
    }
    /**
     * Verifica se um produto existe pelo ID.
     * 
     * @param id ID do produto.
     * @return true se o produto existir.
     * @throws NotFoundProdutoException se o ID for inválido ou o produto não existir.
     */
    public boolean existyById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }

        // Verifica se o produto existe no banco de dados
        if (produtoRepository.existsById(id)) {
            return true;
        } else {
            throw new NotFoundProdutoException("Produto de Id: " + id + " não encontrado");
        }
    }

    /**
     * Validar Produto 
     * @param Produto
     * @throws ProdutoNullException
     * @throws ProdutoPriceException
     */
    private void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getPreco() == null) {
            throw new ProdutoNullException("Nome e preço não podem ser nulos");
        }

        if (produto.getPreco() <= 0) {
            throw new ProdutoPriceException("Preço não pode ser menor ou igual a zero");
        }
    }
    /**
     * 
     * @return Uma Lista de produto
     */
    public List<Produto>listAll()
    {
        return this.produtoRepository.findAll();
    }
}
