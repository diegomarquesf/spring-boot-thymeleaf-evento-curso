package br.com.diego.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoResource {

	@RequestMapping("/cadastrarCurso")
	public String form() {
		return "/curso/cadastrarCurso";
	}
}
