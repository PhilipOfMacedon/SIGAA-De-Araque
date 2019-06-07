package br.com.sgp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgp.core.SessionManager;
import br.com.sgp.entities.Teacher;
import br.com.sgp.repositories.ProjectRepository;
import br.com.sgp.repositories.ResearchGroupRepository;
import br.com.sgp.repositories.ResearcherRepository;
import br.com.sgp.repositories.TeacherRepository;
import br.com.sgp.resources.requests.LoginForm;
import br.com.sgp.resources.requests.SignUpForm;
import br.com.sgp.resources.requests.TokenRequest;
import br.com.sgp.resources.responses.DashboardInfo;

@Service
public class UserService {

	@Autowired
	private ResearcherRepository researcherRepo;

	@Autowired
	private TeacherRepository teacherRepo;

	@Autowired
	private ResearchGroupRepository researchGroupRepo;

	@Autowired
	private ProjectRepository projectRepo;

	public boolean signUp(SignUpForm form) {
		String email = form.getEmail();
		Optional<Teacher> response = teacherRepo.findByEmail(email);
		if (!response.isPresent()) {
			String name = form.getName();
			String surname = form.getSname();
			String cpf = form.getCpf();
			String rg = form.getRg();
			String phone = form.getPhone();
			String password = form.getPassword();
			Teacher t = teacherRepo.save(new Teacher(0, name, surname, cpf, rg, phone, email, password, ""));
			teacherRepo.save(t);
			return true;
		}
		return false;
	}

	public DashboardInfo login(LoginForm form) {
		String email = form.getEmail();
		String password = form.getPassword();
		Optional<Teacher> researcher = teacherRepo.findByEmail(email);
		if (!researcher.isPresent()) {
			if (researcher.get().getPassword().equals(password)) {
				String teacherName = researcher.get().getName();
				int researcherCount = (int) researcherRepo.count();
				int researchGroupCount = (int) researchGroupRepo.count();
				int projectCount = (int) projectRepo.count();
				int token = SessionManager.getSessionID(researcher.get());
				return new DashboardInfo(teacherName, researcherCount, researchGroupCount, projectCount, "Sucesso!", token);
			}
			return new DashboardInfo("", -1, -1, -1, "Senha incorreta!", -1);
		}
		return new DashboardInfo("", -1, -1, -1, "Usuário não registrado!", -1);
	}

	public DashboardInfo getDashboard(TokenRequest request) {
		int token = request.getToken();
		Teacher teacher = SessionManager.getUser(token);
		if (teacher != null) {
			String teacherName = teacher.getName();
			int researcherCount = (int) researcherRepo.count();
			int researchGroupCount = (int) researchGroupRepo.count();
			int projectCount = (int) projectRepo.count();
			return new DashboardInfo(teacherName, researcherCount, researchGroupCount, projectCount, "Sucesso!", token);
		}
		return new DashboardInfo("", -1, -1, -1, "Token inválido!", -1);
	}
}
