package br.com.sgp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.sgp.resources.responses.JSONResponse;
import br.com.sgp.resources.responses.User;

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

	public JSONResponse<DashboardInfo> login(LoginForm form) {
		String email = form.getEmail();
		String password = form.getPassword();
		Optional<Teacher> researcher = teacherRepo.findByEmail(email);
		DashboardInfo info = null;
		String token = "";
		User user = null;
		int code = HttpStatus.FORBIDDEN.value();
		if (researcher.isPresent()) {
			if (researcher.get().getPassword().equals(password)) {
				String teacherName = researcher.get().getName();
				String researcherCount = (int) researcherRepo.count() + "";
				String researchGroupCount = (int) researchGroupRepo.count() + "";
				String projectCount = (int) projectRepo.count() + "";
				code = HttpStatus.OK.value();
				token = SessionManager.getSessionID(researcher.get());
				user = new User(researcher.get());
				info = new DashboardInfo(teacherName, researcherCount, researchGroupCount, projectCount, "Sucesso!");
			} else {
				info = new DashboardInfo("", "", "", "", "Senha incorreta!");
			}
		} else {
			info = new DashboardInfo("", "", "", "", "Usuário não registrado!");
		}
		return new JSONResponse<DashboardInfo>(code, token, info, user);
	}

	public JSONResponse<DashboardInfo> getDashboard(TokenRequest request) {
		String token = request.getToken();
		Teacher teacher = SessionManager.getUser(token);
		DashboardInfo info = null;
		User user = null;
		int code = HttpStatus.FORBIDDEN.value();
		if (teacher != null) {
			code = HttpStatus.OK.value();
			String teacherName = teacher.getName();
			String researcherCount = (int) researcherRepo.count() + "";
			String researchGroupCount = (int) researchGroupRepo.count() + "";
			String projectCount = (int) projectRepo.count() + "";
			user = new User(teacher);
			info = new DashboardInfo(teacherName, researcherCount, researchGroupCount, projectCount, "Sucesso!");
		} else {
			info = new DashboardInfo(null, null, null, null, "Token inválido!");
		}
		return new JSONResponse<DashboardInfo>(code, token, info, user);
	}
}
