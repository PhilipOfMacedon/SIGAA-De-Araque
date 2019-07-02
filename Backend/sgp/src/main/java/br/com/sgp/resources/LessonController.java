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

import br.com.sgp.entities.Lesson;
import br.com.sgp.repositories.LessonRepository;

@RestController
@RequestMapping(value="/lesson")
@CrossOrigin(origins="*")
public class LessonController {
	
	@Autowired
	private LessonRepository lessonRepository; 
	
	@PostMapping(value="/addLesson")
	public Lesson addLesson(@RequestBody Lesson lesson) {
		return lessonRepository.save(lesson);
	}
	
	@PutMapping(value="/alterLesson")
	public Lesson alterLesson(@RequestBody Lesson lesson) {
		return lessonRepository.save(lesson);
	}
	
	@DeleteMapping(value="/remove/{id}")
	public void removeLesson(@PathVariable("id") Integer id) {
		lessonRepository.deleteById(id);
	}
	
	@GetMapping(value="/get/{id}")
	public Optional<Lesson> searchLesson(@PathVariable("id") Integer id) {
		return lessonRepository.findById(id);
	}
	
	@GetMapping(value="/lessons")
	public List<Lesson> searchAllLessons() {
		return lessonRepository.findAll();
	}

}
