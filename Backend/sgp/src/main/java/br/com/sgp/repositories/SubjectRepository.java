package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	Optional<List<Subject>> findByNameContaining(String name);
}
