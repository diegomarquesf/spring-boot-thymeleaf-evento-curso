package br.com.diego.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.domains.Curso;
import br.com.diego.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso insert(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	
	public Curso findById(Long id) {
		return cursoRepository.findById(id).orElseThrow(
				()-> new EntityNotFoundException("O ID " + id + " não Existe"));
	}

	public Curso update(Curso curso) {
		return cursoRepository.save(curso);
	}

}
