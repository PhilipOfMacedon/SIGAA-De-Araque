package br.com.sgp.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.entities.Publication;
import br.com.sgp.repositories.PublicationRepository;

@RestController
@RequestMapping(value="/publication")
public class PublicationController {
	
	@Autowired
	private PublicationRepository publicationRepository; 
	
	@PostMapping(value="/addPublication")
	public Publication addPublication(@RequestBody Publication publication) {
		return publicationRepository.save(publication);
	}
	
	@PutMapping(value="/alterPublication")
	public Publication alterPublication(@RequestBody Publication publication) {
		return publicationRepository.save(publication);
	}
	
	@DeleteMapping(value="/{id}")
	public void removePublication(@PathVariable("id") Integer id) {
		publicationRepository.deleteById(id);
	}
	
	@GetMapping(value="/{id}")
	public Optional<Publication> searchPublication(@PathVariable("id") Integer id) {
		return publicationRepository.findById(id);
	}
	
	@GetMapping(value="/publications")
	public List<Publication> searchAllPublications() {
		return publicationRepository.findAll();
	}
}
