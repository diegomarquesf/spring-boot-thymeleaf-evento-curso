package br.com.diego.domains;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String local;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;
	
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime horaInicio;
	
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime horaFim;

}
