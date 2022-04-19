package br.com.diego.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.diego.domains.Curso;
import br.com.diego.domains.Evento;
import br.com.diego.repositories.CursoRepository;
import br.com.diego.services.EventoService;

@Controller
@RequestMapping("/eventos")
public class EventoResource {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private CursoRepository cursoRepository;
	

	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public String form(Evento evento) {
		return "evento/cadastrar";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String insert(Evento evento) {
		eventoService.insert(evento);
		return "redirect:/eventos/find";
	}
	
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		model.addAttribute("eventos", eventoService.findAll());
		return "/evento/listar";
	}
	
	@ModelAttribute("cursos")
	public List<Curso> findCursos(){
		return cursoRepository.findAll();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateData(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("evento", eventoService.findById(id));
		return "/evento/cadastrar";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Evento evento) {
		eventoService.update(evento);
		return "redirect:/eventos/find";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		eventoService.delete(id);
		return "redirect:/eventos/find";
	}
	
	

}
