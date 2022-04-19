package br.com.diego.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.domains.Curso;
import br.com.diego.domains.Evento;
import br.com.diego.repositories.CursoRepository;
import br.com.diego.repositories.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	

	public void insert(Evento evento) {
		 eventoRepository.save(evento);
	}
	
	public List<Evento> findAll(){
		return eventoRepository.findAll();
	}
	
	public Evento findById(Long id) {
		return eventoRepository.findById(id).orElseThrow(
				()-> new EntityNotFoundException("O ID " + id + " não Existe"));
	}
	
	public void update(Evento evento) {
		eventoRepository.save(evento);
	}
	
	public void delete(Long id) {
		Evento evento = findById(id);
		eventoRepository.delete(evento);
	}
	
	public List<Curso> findCursos() {
		return cursoRepository.findAll();
	}
	

}
