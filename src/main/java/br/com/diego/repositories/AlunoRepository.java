package br.com.diego.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.domains.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	

}
