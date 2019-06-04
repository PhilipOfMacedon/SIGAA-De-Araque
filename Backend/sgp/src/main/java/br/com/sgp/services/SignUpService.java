package br.com.sgp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgp.entities.Teacher;
import br.com.sgp.repositories.ResearcherRepository;

@Service
public class SignUpService {

	@Autowired
	private ResearcherRepository researcherRepo;
	
	public String signUp(String name, String surname, String cpf, String rg, String phone, String email, String password) {
		Teacher t = researcherRepo.save(new Teacher(0, name, surname, cpf, rg, phone, email, password, ""));
		return "ID de " + t.getName() + ": " + t.getId();
	}
}
