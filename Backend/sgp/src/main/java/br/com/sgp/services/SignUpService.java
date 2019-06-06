package br.com.sgp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgp.entities.Researcher;
import br.com.sgp.entities.Teacher;
import br.com.sgp.repositories.ResearcherRepository;
import br.com.sgp.resources.requests.SignUpForm;

@Service
public class SignUpService {

	@Autowired
	private ResearcherRepository researcherRepo;
	
	public boolean signUp(SignUpForm form) {
		String email = form.getEmail();
		Optional<Researcher> response = researcherRepo.findByEmail(email);
		if (!response.isPresent()) {
			String name = form.getName();
			String surname = form.getSname();
			String cpf = form.getCpf();
			String rg = form.getRg();
			String phone = form.getPhone();
			String password = form.getPassword();
			Teacher t = researcherRepo.save(new Teacher(0, name, surname, cpf, rg, phone, email, password, ""));
			researcherRepo.save(t);
			return true;
		}
		return false;
	}
}
