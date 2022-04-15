package br.com.diego.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String form() {
		return "evento/cadastrar";
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
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
	
	
	@GetMapping("/find/data")
		public String getByData(@RequestParam("data") LocalDate data, ModelMap model) {
		model.addAttribute("eventos", eventoService.findByData(data));
		return "/evento/listar";
	}
	

}
