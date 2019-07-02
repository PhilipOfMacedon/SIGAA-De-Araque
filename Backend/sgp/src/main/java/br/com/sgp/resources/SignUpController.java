package br.com.sgp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.resources.requests.SignUpForm;
import br.com.sgp.services.UserService;

@RestController
@RequestMapping(value = "/api/signup")
public class SignUpController {

	@Autowired
	private UserService signupService;
	
	@PostMapping(value = "/submit")
	public ResponseEntity<String> registerNewTeacher(@RequestBody SignUpForm form) {
		System.err.println("ENTREI");
		if (!form.hasEmptyFields()) {
			boolean saved = signupService.signUp(form);
			if (saved) {
				return new ResponseEntity<String>("Professor cadastrado com sucesso!", HttpStatus.OK);
			}
			return new ResponseEntity<String>("Use um e-mail diferente! Esse e-mail já está cadastrado por outro pesquisador!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Requisição inválida!", HttpStatus.OK);
	}
	
}
