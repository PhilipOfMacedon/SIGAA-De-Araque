package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	Optional<List<Project>> findByNameContaining(String name);
}
