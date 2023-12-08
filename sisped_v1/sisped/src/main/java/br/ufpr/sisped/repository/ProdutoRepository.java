package br.ufpr.sisped.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.sisped.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
