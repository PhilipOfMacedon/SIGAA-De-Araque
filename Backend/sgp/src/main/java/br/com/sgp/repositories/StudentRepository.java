package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import br.com.sgp.entities.Student;

public interface StudentRepository extends ResearcherBaseRepository<Student> {
	
	Optional<List<Student>> findByNameContaining(String name);
}
