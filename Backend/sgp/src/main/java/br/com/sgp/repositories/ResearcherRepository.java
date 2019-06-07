package br.com.sgp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Researcher;

public interface ResearcherRepository extends JpaRepository<Researcher, Integer> {
	
	Optional<Researcher> findByEmail(String email);
}
