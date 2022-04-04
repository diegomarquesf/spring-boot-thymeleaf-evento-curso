package br.com.diego.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.diego.domains.Curso;
import br.com.diego.repositories.CursoRepository;

@Component
public class StringToCursoConverter implements Converter<String, Curso> {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public Curso convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
			Long id = Long.valueOf(text);
			return cursoRepository.getById(id);
	}

}
