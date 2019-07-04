package br.com.sgp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.resources.requests.LoginForm;
import br.com.sgp.resources.requests.TokenRequest;
import br.com.sgp.resources.responses.DashboardInfo;
import br.com.sgp.resources.responses.JSONResponse;
import br.com.sgp.resources.responses.User;
import br.com.sgp.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class CommonController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login/request")
	@ResponseBody
	public JSONResponse<String> requestLogin() {
		return new JSONResponse<String>(HttpStatus.FORBIDDEN.value(), null, "User must login to continue.", new User());
	}
	
	@PostMapping("/login/submit")
	@ResponseBody
	public JSONResponse<DashboardInfo> index(@RequestBody LoginForm form) {
		return userService.login(form);
	}
	
	@PostMapping("/home")
	@ResponseBody
	public JSONResponse<DashboardInfo> index(@RequestBody TokenRequest request) {
		return userService.getDashboard(request);
	}
	
	//public void 
}
