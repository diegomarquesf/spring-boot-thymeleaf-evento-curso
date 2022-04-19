package br.com.diego.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.diego.domains.Curso;
import br.com.diego.services.CursoService;

@Component
public class StringToCursoConverter implements Converter<String, Curso>{

	@Autowired
	private CursoService cursoService;
	
	@Override
	public Curso convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return cursoService.findById(id);
	}
	

}
