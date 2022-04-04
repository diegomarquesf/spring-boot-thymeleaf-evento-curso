package br.com.diego.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.diego.domains.Curso;
import br.com.diego.domains.Evento;
import br.com.diego.repositories.CursoRepository;
import br.com.diego.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventoResource {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	

	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public String form() {
		return "evento/cadastrar";
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	public String insert(Evento evento) {
		eventoRepository.save(evento);
		return "redirect:/eventos/find";
	}
	
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		model.addAttribute("eventos", eventoRepository.findAll());
		return "/evento/listar";
	}
	
	@ModelAttribute("cursos")
	public List<Curso> findCursos(){
		return cursoRepository.findAll();
	}
	
	
	/**@RequestMapping("details/{id}")
	public String detailCurso(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("curso", cursoRepository.findById(id));
		return "/curso/detalhesCurso";
	}**/
	
	


	
	
}
