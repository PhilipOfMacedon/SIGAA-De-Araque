package br.com.sgp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Researcher;

public interface ResearcherBaseRepository<T extends Researcher> extends JpaRepository<T, Integer> {
	
	Optional<T> findByEmail(String email);
}
