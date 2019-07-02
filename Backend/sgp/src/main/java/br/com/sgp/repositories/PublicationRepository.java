package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	
	Optional<List<Publication>> findByNameContaining(String name);
}
