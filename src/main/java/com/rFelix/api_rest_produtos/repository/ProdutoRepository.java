package com.rFelix.api_rest_produtos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rFelix.api_rest_produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
