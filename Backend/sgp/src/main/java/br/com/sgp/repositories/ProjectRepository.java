package br.com.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
