package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
 
	
	
	
}