package br.edu.infnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.domain.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {
 
	
	
	
}