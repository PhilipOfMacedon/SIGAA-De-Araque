package br.com.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
