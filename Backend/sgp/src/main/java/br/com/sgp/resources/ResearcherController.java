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

import br.com.sgp.entities.Researcher;
import br.com.sgp.repositories.ResearcherRepository;

@RestController(value="/researcher")
public class ResearcherController {
	
	@Autowired
	private ResearcherRepository researcherRepository; 
	
	@PostMapping
	public Researcher cadastrarPesquisador(@RequestBody Researcher researcher) {
		return researcherRepository.save(researcher);
	}
	
	@PutMapping
	public Researcher alterarPesquisador(@RequestBody Researcher researcher) {
		return researcherRepository.save(researcher);
	}
	
	@DeleteMapping("/{id}")
	public void excluirPesquisador(@PathVariable("id") Integer id) {
		researcherRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Researcher> buscarPesquisador(@PathVariable("id") Integer id) {
		return researcherRepository.findById(id);
	}
	
	@GetMapping("/pesquisadores")
	public List<Researcher> buscarTodosProjetos() {
		return researcherRepository.findAll();
	}
}
