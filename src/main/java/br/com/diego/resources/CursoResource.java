package br.com.diego.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.diego.domains.Curso;
import br.com.diego.services.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	

	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public String form(Curso curso) {
		return "curso/cadastrar";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String insert(Curso curso) {
		cursoService.insert(curso);
		return "redirect:/cursos/find";
	}
	
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		model.addAttribute("cursos", cursoService.findAll());
		return "/curso/listar";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateData(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("curso", cursoService.findById(id));
		return "/curso/cadastrar";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Curso curso) {
		cursoService.update(curso);
		return "redirect:/cursos/find";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		if (cursoService.cursoHasEvento(id)) {
			return "redirect:/cursos/find";
		}else {
			cursoService.delete(id);
		}
			return "redirect:/cursos/find";
	}
	

	
	
}
