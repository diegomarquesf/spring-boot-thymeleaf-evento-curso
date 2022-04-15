package br.com.diego.services;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.domains.Evento;
import br.com.diego.repositories.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	
	public Evento insert(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public List<Evento> findAll(){
		return eventoRepository.findAll();
	}
	
	public Evento findById(Long id) {
		return eventoRepository.findById(id).orElseThrow(
				()-> new EntityNotFoundException("O ID " + id + " não Existe"));
	}
	
	
	public List<Evento> findByData (LocalDate data){
		return eventoRepository.findByData(data);
	}
	
	

}
