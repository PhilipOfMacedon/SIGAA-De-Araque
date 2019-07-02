package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import br.com.sgp.entities.Teacher;

public interface TeacherRepository extends ResearcherBaseRepository<Teacher> {
	
	Optional<List<Teacher>> findByNameContaining(String name);
}
