package com.rFelix.api_rest_produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rFelix.api_rest_produtos.model.Produto;
import com.rFelix.api_rest_produtos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
        
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        Produto produtoExistente = produtoRepository.findById(id).orElse(null);
        if(produtoExistente != null){
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produtoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
    
}
