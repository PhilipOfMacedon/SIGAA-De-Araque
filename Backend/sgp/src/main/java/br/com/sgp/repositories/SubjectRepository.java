package br.com.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
