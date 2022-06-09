package com.gengaming.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gengaming.lojagames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List <Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	public List <Produto> findByPrecoGreaterThan(@Param("precoMaior") BigDecimal preco);
	
	public List <Produto> findByPrecoLessThan(@Param("precoMenor") BigDecimal preco);

	public List <Produto> findByPrecoBetween(BigDecimal valor1, BigDecimal valor2);
	
	public List <Produto> findAllByConsoleContainingIgnoreCase(@Param("console") String console);
}
