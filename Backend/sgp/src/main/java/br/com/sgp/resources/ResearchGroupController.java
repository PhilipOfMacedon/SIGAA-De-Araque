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

import br.com.sgp.entities.ResearchGroup;
import br.com.sgp.repositories.ResearchGroupRepository;

@RestController(value="/researchgroup")
public class ResearchGroupController {
	
	@Autowired
	private ResearchGroupRepository researchGroupRepository; 
	
	@PostMapping
	public ResearchGroup cadastrarGrupoDePesquisa(@RequestBody ResearchGroup researchGroup) {
		return researchGroupRepository.save(researchGroup);
	}
	
	@PutMapping
	public ResearchGroup alterarGrupoDePesquisa(@RequestBody ResearchGroup researchGroup) {
		return researchGroupRepository.save(researchGroup);
	}
	
	@DeleteMapping("/{id}")
	public void excluirGrupoDePesquisa(@PathVariable("id") Integer id) {
		researchGroupRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<ResearchGroup> buscarGrupoDePesquisa(@PathVariable("id") Integer id) {
		return researchGroupRepository.findById(id);
	}
	
	@GetMapping("/gruposDePesquisa")
	public List<ResearchGroup> buscarTodosGruposDePesquisa() {
		return researchGroupRepository.findAll();
	}
}
