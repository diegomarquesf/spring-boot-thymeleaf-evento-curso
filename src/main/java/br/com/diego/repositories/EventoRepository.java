package br.com.diego.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.diego.domains.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
	
	
	@Query(value = "SELECT e from Evento e WHERE e.data = ?1")
	public List<Evento> findByData (LocalDate data);
}
