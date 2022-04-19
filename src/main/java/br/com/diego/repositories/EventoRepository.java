package br.com.diego.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.domains.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
	
	

}
