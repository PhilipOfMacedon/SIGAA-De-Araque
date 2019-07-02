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

import br.com.sgp.entities.Researcher;
import br.com.sgp.repositories.ResearcherRepository;

@RestController
@RequestMapping(value="/researcher")
public class ResearcherController {
	
	@Autowired
	private ResearcherRepository researcherRepository; 
	
	@PostMapping(value="/addResearcher")
	public Researcher caddResearcher(@RequestBody Researcher researcher) {
		return researcherRepository.save(researcher);
	}
	
	@PutMapping(value="/alterResearcher")
	public Researcher alterResearcher(@RequestBody Researcher researcher) {
		return researcherRepository.save(researcher);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void removeResearcher(@PathVariable("id") Integer id) {
		researcherRepository.deleteById(id);
	}
	
	@GetMapping(value="/get/{id}")
	public Optional<Researcher> searchResearcher(@PathVariable("id") Integer id) {
		return researcherRepository.findById(id);
	}
	
	@GetMapping(value="/researchers")
	public List<Researcher> searchAllResearcher() {
		return researcherRepository.findAll();
	}
}
