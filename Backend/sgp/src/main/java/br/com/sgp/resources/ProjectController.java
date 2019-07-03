package br.com.sgp.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.entities.Project;
import br.com.sgp.repositories.ProjectRepository;
import br.com.sgp.resources.responses.JsonSimpleResponse;

@RestController
@RequestMapping(value="/project")
@CrossOrigin(origins="*")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository; 
	
	@PostMapping(value="/addProject")
	public Project addProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@PutMapping(value="/alterProject")
	public Project alterProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteProject(@PathVariable("id") Integer id) {
		projectRepository.deleteById(id);
	}
	
	@GetMapping(value="/get/{id}")
	public Optional<Project> searchProject(@PathVariable("id") Integer id) {
		return projectRepository.findById(id);
	}
	
	@GetMapping(value="/projects")
	public JsonSimpleResponse searchAllProjects() {
		List<Project> projects = projectRepository.findAll();
		JsonSimpleResponse jsr = new JsonSimpleResponse()
				.addPair("status", new Integer(HttpStatus.OK.value()))
				.addPair("data", projects);;
		
		return jsr;
	}
}
