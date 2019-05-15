package br.com.sgp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.services.SignUpService;

@RestController
@RequestMapping(value = "/signup")
public class SignUpController {

	@Autowired
	private SignUpService signupService;
	
	@RequestMapping(value = "/")
	public String testInsertion() {
		return signupService.signUp("João", "Joelstrela", "CPF KKKKK", "RG KKKKK", "FONE KKKK", "mail.com", "1234");
	}
}
