package br.com.sgp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
	
	Optional<List<Lesson>> findByNameContaining(String name);
}
