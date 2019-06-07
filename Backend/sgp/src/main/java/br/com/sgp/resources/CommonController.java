package br.com.sgp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.resources.requests.LoginForm;
import br.com.sgp.resources.requests.TokenRequest;
import br.com.sgp.resources.responses.DashboardInfo;
import br.com.sgp.services.UserService;

@RestController
public class CommonController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	@ResponseBody
	public DashboardInfo index(@RequestBody LoginForm form) {
		return userService.login(form);
	}
	
	@PostMapping("/home")
	@ResponseBody
	public DashboardInfo index(@RequestBody TokenRequest request) {
		return userService.getDashboard(request);
	}
}
