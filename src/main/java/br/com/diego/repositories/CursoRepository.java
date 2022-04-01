package br.com.diego.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.domains.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
