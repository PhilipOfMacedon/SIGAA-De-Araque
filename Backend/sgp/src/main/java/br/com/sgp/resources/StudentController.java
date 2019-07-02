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

import br.com.sgp.entities.Student;
import br.com.sgp.repositories.StudentRepository;

@RestController(value="/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository; 
	
	@PostMapping
	public Student cadastrarEstudante(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping
	public Student alterarEstudante(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@DeleteMapping("/{id}")
	public void excluirEstudante(@PathVariable("id") Integer id) {
		studentRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> buscarEstudante(@PathVariable("id") Integer id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping("/estudantes")
	public List<Student> buscarTodosEstudantes() {
		return studentRepository.findAll();
	}
}
