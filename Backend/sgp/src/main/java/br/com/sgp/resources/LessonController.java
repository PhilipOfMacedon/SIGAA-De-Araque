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

import br.com.sgp.entities.Lesson;
import br.com.sgp.repositories.LessonRepository;

@RestController(value="/lesson")
public class LessonController {
	
	@Autowired
	private LessonRepository lessonRepository; 
	
	@PostMapping
	public Lesson cadastrarAula(@RequestBody Lesson lesson) {
		return lessonRepository.save(lesson);
	}
	
	@PutMapping
	public Lesson alterarAula(@RequestBody Lesson lesson) {
		return lessonRepository.save(lesson);
	}
	
	@DeleteMapping("/{id}")
	public void excluirAula(@PathVariable("id") Integer id) {
		lessonRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Lesson> buscarAula(@PathVariable("id") Integer id) {
		return lessonRepository.findById(id);
	}
	
	@GetMapping("/aulas")
	public List<Lesson> buscarTodasAulas() {
		return lessonRepository.findAll();
	}

}
