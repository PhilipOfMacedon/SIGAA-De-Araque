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

import br.com.sgp.entities.Subject;
import br.com.sgp.repositories.SubjectRepository;

@RestController
@RequestMapping(value="/subjectcontroller")
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository; 
	
	@PostMapping(value="/addSubject")
	public Subject cadastrarDisciplina(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@PutMapping(value="/alterSubject")
	public Subject alterSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@DeleteMapping(value="/{id}")
	public void removeSubject(@PathVariable("id") Integer id) {
		subjectRepository.deleteById(id);
	}
	
	@GetMapping(value="/{id}")
	public Optional<Subject> searchSubject(@PathVariable("id") Integer id) {
		return subjectRepository.findById(id);
	}
	
	@GetMapping(value="/subjects")
	public List<Subject> searchAllSubjects() {
		return subjectRepository.findAll();
	}
}
