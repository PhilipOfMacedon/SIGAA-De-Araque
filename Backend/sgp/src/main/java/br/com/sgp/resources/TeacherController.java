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

import br.com.sgp.entities.Teacher;
import br.com.sgp.repositories.TeacherRepository;

@RestController
@RequestMapping(value="/professorcontroller")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository; 
	
	@PostMapping(value="/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@PutMapping(value="alterTeacher")
	public Teacher alterTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@DeleteMapping(value="/remove/{id}")
	public void removeTeacher(@PathVariable("id") Integer id) {
		teacherRepository.deleteById(id);
	}
	
	@GetMapping(value="/search/{id}")
	public Optional<Teacher> searchTeacher(@PathVariable("id") Integer id) {
		return teacherRepository.findById(id);
	}
	
	@GetMapping(value="/teachers")
	public List<Teacher> searchAllTeacher() {
		return teacherRepository.findAll();
	}
}
