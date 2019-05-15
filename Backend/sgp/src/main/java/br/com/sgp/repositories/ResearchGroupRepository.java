package br.com.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.ResearchGroup;

public interface ResearchGroupRepository extends JpaRepository<ResearchGroup, Integer> {

}
