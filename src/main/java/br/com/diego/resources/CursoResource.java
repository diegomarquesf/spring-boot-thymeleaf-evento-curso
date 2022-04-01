package br.com.diego.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.diego.domains.Curso;
import br.com.diego.repositories.CursoRepository;

@Controller
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoRepository cursoRepository;

	@RequestMapping(value="/cadastrarCurso", method = RequestMethod.GET)
	public String form() {
		return "/curso/cadastrarCurso";
	}
	
	@RequestMapping(value="/cadastrarCurso", method = RequestMethod.POST)
	public String insert(Curso curso) {
		cursoRepository.save(curso);
		return "redirect:/cursos/home";
	}
	
	@RequestMapping(value="/listarCurso", method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		model.addAttribute("cursos", cursoRepository.findAll());
		return "/home";
	}
	
	
	

	
	
}
