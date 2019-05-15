package br.com.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

}
