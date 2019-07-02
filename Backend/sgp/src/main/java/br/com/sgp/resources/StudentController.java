package br.com.sgp.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.entities.Student;
import br.com.sgp.repositories.StudentRepository;

@RestController
@RequestMapping(value="/student")
@CrossOrigin(origins="*")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository; 
	
	@PostMapping(value="/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping(value="/alterStudent")
	public Student alterStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void removeStudent(@PathVariable("id") Integer id) {
		studentRepository.deleteById(id);
	}
	
	@GetMapping(value="/search/{id}")
	public Optional<Student> searchStudent(@PathVariable("id") Integer id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping(value="/student")
	public List<Student> searchAllStudents() {
		return studentRepository.findAll();
	}
}
