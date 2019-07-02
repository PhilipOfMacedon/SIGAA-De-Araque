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
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.entities.Publication;
import br.com.sgp.repositories.PublicationRepository;

@RestController(value="/publication")
public class PublicationController {
	
	@Autowired
	private PublicationRepository publicationRepository; 
	
	@PostMapping
	public Publication cadastrarPublicacao(@RequestBody Publication publication) {
		return publicationRepository.save(publication);
	}
	
	@PutMapping
	public Publication alterarPublicacao(@RequestBody Publication publication) {
		return publicationRepository.save(publication);
	}
	
	@DeleteMapping("/{id}")
	public void excluirPublicacao(@PathVariable("id") Integer id) {
		publicationRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Publication> buscarPublicacao(@PathVariable("id") Integer id) {
		return publicationRepository.findById(id);
	}
	
	@GetMapping("/publicacoes")
	public List<Publication> buscarTodasPublicacoes() {
		return publicationRepository.findAll();
	}
}
