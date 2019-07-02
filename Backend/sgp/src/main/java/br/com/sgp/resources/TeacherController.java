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

import br.com.sgp.entities.Teacher;
import br.com.sgp.repositories.TeacherRepository;

@RestController(value="/professorcontroller")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository; 
	
	@PostMapping
	public Teacher cadastrarProfessor(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@PutMapping
	public Teacher alterarProfessor(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@DeleteMapping("/{id}")
	public void excluirProfessor(@PathVariable("id") Integer id) {
		teacherRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Teacher> buscarProfessor(@PathVariable("id") Integer id) {
		return teacherRepository.findById(id);
	}
	
	@GetMapping("/professores")
	public List<Teacher> buscarTodosProfessores() {
		return teacherRepository.findAll();
	}
}
