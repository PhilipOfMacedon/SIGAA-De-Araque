package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import br.com.sgp.entities.Researcher;

public interface ResearcherRepository extends ResearcherBaseRepository<Researcher> {
	
	Optional<List<Researcher>> findByNameContaining(String name);
}
