package br.com.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Researcher;

public interface ResearcherRepository extends JpaRepository<Researcher, Integer> {

}
