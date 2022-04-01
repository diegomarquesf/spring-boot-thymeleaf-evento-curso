package br.com.diego.domains;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Curso {
	
	private String nome;
	private String local;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;

}
