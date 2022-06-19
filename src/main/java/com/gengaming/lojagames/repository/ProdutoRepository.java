package com.gengaming.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gengaming.lojagames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List <Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	
	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);

	public List <Produto> findByPrecoBetween(BigDecimal valor1, BigDecimal valor2);
	
	public List <Produto> findAllByConsoleContainingIgnoreCase(@Param("console") String console);
	
	public Produto save(Optional<Produto> produto);
}
