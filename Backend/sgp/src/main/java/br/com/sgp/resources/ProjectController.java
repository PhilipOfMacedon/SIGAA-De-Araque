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

import br.com.sgp.entities.Project;
import br.com.sgp.repositories.ProjectRepository;

@RestController(value="/project")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository; 
	
	@PostMapping
	public Project cadastrarProjeto(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@PutMapping
	public Project alterarProjeto(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@DeleteMapping("/{id}")
	public void excluirProjeto(@PathVariable("id") Integer id) {
		projectRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Project> buscarProjeto(@PathVariable("id") Integer id) {
		return projectRepository.findById(id);
	}
	
	@GetMapping("/projetos")
	public List<Project> buscarTodosProjetos() {
		return projectRepository.findAll();
	}
}
