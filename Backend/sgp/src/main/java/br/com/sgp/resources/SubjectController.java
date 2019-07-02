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

import br.com.sgp.entities.Subject;
import br.com.sgp.repositories.SubjectRepository;

@RestController(value="/subjectcontroller")
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository; 
	
	@PostMapping
	public Subject cadastrarDisciplina(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@PutMapping
	public Subject alterarDisciplina(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@DeleteMapping("/{id}")
	public void excluirSubject(@PathVariable("id") Integer id) {
		subjectRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Subject> buscarDicisplina(@PathVariable("id") Integer id) {
		return subjectRepository.findById(id);
	}
	
	@GetMapping("/projetos")
	public List<Subject> buscarTodasDisciplinas() {
		return subjectRepository.findAll();
	}
}
